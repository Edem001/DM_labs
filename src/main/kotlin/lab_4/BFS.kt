package lab_4

import java.util.*

fun bfs(graph: Array<IntArray>, s: Int, t: Int, parent: IntArray): Boolean {

    val visited = BooleanArray(V)
    for (i in 0 until V) visited[i] = false

    val queue = LinkedList<Int>()
    queue.add(s)
    visited[s] = true
    parent[s] = -1

    while (queue.size != 0) {
        val u = queue.poll()
        for (v in 0 until V) {
            if (!visited[v] && graph[u][v] > 0
            ) {
                if (v == t) {
                    parent[v] = u
                    return true
                }
                queue.add(v)
                parent[v] = u
                visited[v] = true
            }
        }
    }

    return false
}