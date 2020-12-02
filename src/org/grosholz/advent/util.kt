package org.grosholz.advent

fun timed(solve: () -> Int, eval: (Long, Int) -> Unit) {
    val start = System.nanoTime()
    val res = solve()
    val time = System.nanoTime() - start
    eval(time, res)
}
