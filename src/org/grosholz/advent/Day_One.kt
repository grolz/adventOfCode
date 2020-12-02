package org.grosholz.advent

import java.io.File


fun solve(input: List<Int>, sum: Int): Int {
    var iteratorIndex = input.size - 1
    while (iteratorIndex > 0) {
        val currentNumber = input.get(iteratorIndex)
        input.take(iteratorIndex - 1).forEach { number ->
            if (number + currentNumber == sum)
                return (number * currentNumber)
        }
        iteratorIndex--
    }
    return -1
}

fun main() {
    val inputs = ArrayList<Int>()


    File("./resources/day_one_data.txt").forEachLine { line -> inputs.add(Integer.valueOf(line)) }

    timed({ solve(inputs, 2020) }, { time, res -> println("Solution Part One, List ($time ns): $res") })
    timed({ solve_three(inputs, 2020) }, { time, res -> println("Solution Part One, List ($time ns): $res") })
}

fun solve_three(input: List<Int>, sum: Int): Int {
    input.forEach {currentNumber ->
        val solve = solve(input, sum - currentNumber)
        if (solve > 0)
            return (solve * currentNumber)
    }
    return -1
}
