package com.github.pozo.adventofcode2017.day1

import java.io.File

fun main(args: Array<String>) {
    val testInputs = mapOf(
            "1122" to 3,
            "1111" to 4,
            "1234" to 0,
            "91212129" to 9
    )

    File(ClassLoader.getSystemResource("day1/input.txt").file).forEachLine { line ->
        print("actual : ${calculate(line)} ")
    }
    for (testInput in testInputs) {
        print("actual : ${calculate(testInput.key)}")
        println("expected : ${testInput.value}")
    }

}

private fun calculate(rawNumber: String): Int {
    var number = rawNumber
    var sum = 0

    val firstDigit = number.first()
    val lastDigit = number.last()

    if (firstDigit == lastDigit) {
        sum += Integer.parseInt(firstDigit.toString())
    }

    var currentDigit: Char
    var nextDigit: Char

    while (number.length > 1) {
        currentDigit = number[0]
        number = number.substring(1)
        nextDigit = number[0]

        if (currentDigit == nextDigit) {
            sum += Integer.parseInt(currentDigit.toString())
        }
    }
    return sum
}
