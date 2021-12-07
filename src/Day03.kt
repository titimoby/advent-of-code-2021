fun main() {
    fun part1(input: List<String>): Int {
        val bitRange = 0 until input.first().length

        val gammaRateBinary = bitRange
                .mapIndexed { index, _ ->
                    input.map { it.toCharArray() }
                            .groupingBy { it[index] }
                            .eachCount()
                            .maxByOrNull { it.value }?.key
                }
                .joinToString("")

        val epsilonRate = gammaRateBinary.map { char: Char ->
            if (char == '0') '1' else '0'
        }.joinToString("").toInt(2)


        return gammaRateBinary.toInt(2) * epsilonRate
    }

    fun part2(input: List<String>): Int {
        val bitLength = input.first().length

        fun determineOxygen(): Int {
            var oxygens = input
            for (i in 0 until bitLength) {
                val oxygensCount = oxygens
                        .groupingBy { it[i] }
                        .eachCount()
                val maxEntries = oxygensCount.filterValues { it == oxygensCount.values.maxOrNull() }
                val bitCriteria = if (maxEntries.size > 1) '1' else maxEntries.keys.first()

                oxygens = oxygens.filter { bit ->
                    bit[i] == bitCriteria
                }
            }
            return oxygens.first().toInt(2)
        }

        fun determineCo2(): Int {
            var co2 = input
            for (i in 0 until bitLength) {
                val co2Count = co2
                        .groupingBy { it[i] }
                        .eachCount()
                val minEntries = co2Count.filterValues { it == co2Count.values.minOrNull() }
                val bitCriteria = if (minEntries.size > 1) '0' else minEntries.keys.first()

                co2 = co2.filter { bit ->
                    bit[i] == bitCriteria
                }
            }
            return co2.first().toInt(2)
        }

        return determineOxygen() * determineCo2()
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
