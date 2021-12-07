fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        input.map { it.split(" ") }
                .map {
                    val intValue = it.last().toInt()
                    when (it.first()) {
                        "forward" -> horizontal += intValue
                        "up" -> depth -= intValue
                        "down" -> depth += intValue
                    }
                }
        return depth * horizontal
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var depth = 0
        var horizontal = 0
        input.map { it.split(" ") }
                .map {
                    val intValue = it.last().toInt()
                    when (it.first()) {
                        "forward" -> {
                            horizontal += intValue
                            depth += aim * intValue
                        }
                        "up" -> aim -= intValue
                        "down" -> aim += intValue
                    }
                }
        return depth * horizontal
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
