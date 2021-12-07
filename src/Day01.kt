fun main() {
    fun part1(input: List<Int>): Int {
        return input
                // prendre les entiers 2 par 2
                .windowed(2)
                // compter les cas ou le second est supérieur au premier
                .count { (first, second) -> second > first }
    }

    fun part2(input: List<Int>): Int {
        return input
                // prendre les entiers 3 par 3
                .windowed(3)
                // regarder 2 groupes par 2 groupes d'entiers
                .windowed(2)
                // compter les cas ou la somme des entiers du second groupe est supérieure
                .count { (first, second) -> second.sum() > first.sum() }
    }

    // comparer A + B + C et B + C + D
    // revient  à comparer A et D
    fun part2Alternative(input: List<Int>): Int {
        return input
                // prendre les entiers 4 par 4
                .windowed(4)
                // compter les cas où le quatrième entier est supérieur au premier
                .count { it[3] > it[0] }
    }

    // test avec les données de l'exemple de l'énoncé
    val testInput = readInputAsInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)
    check(part2Alternative(testInput) == 5)

    val input = readInputAsInt("Day01")
    println(part1(input))
    println(part2(input))
    println(part2Alternative(input))
}
