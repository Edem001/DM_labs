package lab_3

fun findMins(adj: Array<IntArray>, i: Int): Pair<Int, Int> {
    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE
    for (j in 0 until N) {
        if (i == j) continue
        if (adj[i][j] <= first) {
            second = first
            first = adj[i][j]
        } else if (adj[i][j] <= second &&
            adj[i][j] != first
        ) second = adj[i][j]
    }
    return first to second
}