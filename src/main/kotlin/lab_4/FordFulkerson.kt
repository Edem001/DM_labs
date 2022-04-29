package lab_4

import kotlin.math.min

fun fordFulkerson(graph: Array<IntArray>, s: Int, t: Int): Int {
    var u: Int
    var v: Int


    val rGraph = Array(V) { IntArray(V) }
    u = 0
    while (u < V) {
        v = 0
        while (v < V) {
            rGraph[u][v] = graph[u][v]
            v++
        }
        u++
    }

    val parent = IntArray(V)
    var max_flow = 0


    while (bfs(rGraph, s, t, parent)) {

        var path_flow = Int.MAX_VALUE
        v = t
        while (v != s) {
            u = parent[v]
            path_flow = min(path_flow, rGraph[u][v])
            v = parent[v]
        }

        v = t
        while (v != s) {
            u = parent[v]
            rGraph[u][v] -= path_flow
            rGraph[v][u] += path_flow
            v = parent[v]
        }

        max_flow += path_flow
    }

    return max_flow
}