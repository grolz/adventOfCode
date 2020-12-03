package org.grosholz.advent

import java.io.File
import java.math.BigDecimal


fun main() {
    val map = ArrayList<String>()

    File("./resources/day_three_data.txt").forEachLine { line -> map.add(line) }

    val mapTile = TreeMapTile(map)
    println(mapTile.countTrees(3, 1))

    val path = ArrayList<String>()
    path.add ("11")
    path.add ("31")
    path.add ("51")
    path.add ("71")
    path.add ("12")

    println(path.map {
        mapTile.countTrees(Character.getNumericValue(it[0]), Character.getNumericValue(it[1])) }.reduce { a: BigDecimal, b:BigDecimal -> a * b} )

}

class TreeMapTile(val map: List<String>) {
    private val width: Int
    val tree: Char = '#'
    val openSpace = "."

    init {
         width = map[0].length
    }

    fun countTrees(x_step: Int, y_step: Int): BigDecimal {
        var treeCount: BigDecimal = BigDecimal(0)
        var step = 0

        while ((step * y_step) < map.size){
            if (goto(step * x_step, step * y_step) == (tree)){
                treeCount++
            }
            step++
        }
        return  treeCount
    }

    fun goto(x: Int, y: Int): Char {
        return map[y][x % width]
    }
}
