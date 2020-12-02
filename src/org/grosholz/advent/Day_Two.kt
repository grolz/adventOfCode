package org.grosholz.advent

import java.io.File


fun main() {
    val inputs = ArrayList<PasswordLine>()


    File("./resources/day_two_data.txt").forEachLine { line ->
        val split = line.split(" ")
        val min_max_occourence = split[0].split("-")
        inputs.add(
            PasswordLine(line,
                min_max_occourence[0].toInt(),
                min_max_occourence[1].toInt(),
                split[1].take(1),
                split[2]
            )
        )
    }

    timed(
        { inputs.filter { it.isValid_sled_rental() }.count() },
        { time, res -> println("Solution Part One, List ($time ns): $res") })
    timed(
        { inputs.filter { it.isValid_tobogan() }.count() },
        { time, res -> println("Solution Part Two, List ($time ns): $res") })

}

class PasswordLine(val line: String,
                   val firstNumber: Int,
                   val secondNumber: Int,
                   val recommendedLetter: String,
                   val password: String
) {
    fun isValid_sled_rental(): Boolean {

        val occourences: Int = password.filter { it == recommendedLetter[0] }.count()
        if (occourences >= firstNumber && occourences <= secondNumber) {
            return true
        }
        return false
    }

    fun isValid_tobogan(): Boolean {
        if ((password[firstNumber - 1] == recommendedLetter[0]).xor(
            password[secondNumber - 1] == recommendedLetter[0])) {
            println("${line} valid")
            return true
        }
        println("${line} invalid")
        return false
    }
}
