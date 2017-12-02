package com.github.pozo.adventofcode2017.day2

import java.io.File
import java.lang.Integer.parseInt

data class MutablePair(var min: Int, var max: Int) {
    fun updateMax(candidate: Int): MutablePair {
        max = if (candidate > max) candidate else max; return this
    }

    fun updateMin(candidate: Int): MutablePair {
        min = if (candidate < min) candidate else min; return this
    }

    fun subtract(): Int = max - min
}

fun main(args: Array<String>) {
    val file = ClassLoader.getSystemResource("day2/input.txt").file

    val checksum = File(file)
            .readLines()
            .sumBy { line ->
                line.split("\t")
                        .map(::parseInt)
                        .fold(MutablePair(Int.MAX_VALUE, Int.MIN_VALUE), { total, next ->
                            println(total)
                            total.updateMax(next).updateMin(next)

                        })
                        .subtract()
            }

    println(checksum)
}

