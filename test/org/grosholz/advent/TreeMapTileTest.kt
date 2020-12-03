package org.grosholz.advent


fun main() {
    val map = ArrayList<String>()
    map.add("..##......#")
    map.add("#...#...#..")
    map.add(".#....#..#.")
    map.add("..#.#...#.#")
    map.add(".#...##..#.")
    map.add("..#.##.....")
    map.add(".#.#.#....#")
    map.add(".#........#")
    map.add("#.##...#...")
    map.add("#...##....#")
    map.add(".#..#...#.#")

    val treeMapTile = TreeMapTile(map)
    println(treeMapTile.goto(13, 0))
    val path = ArrayList<String>()
    path.add ("11")
    path.add ("31")
    path.add ("51")
    path.add ("71")
    path.add ("12")

println(    path.map {
    val countTrees = treeMapTile.countTrees(Character.getNumericValue(it[0]), Character.getNumericValue(it[1]))
    println(countTrees)
    countTrees
}.reduce { a, b -> a*b }
)}
