package lab_2

class Dijkstra(
    val V: Int
) {
    fun minDistance(dist: IntArray, sptSet: Array<Boolean>): Int {
        var min = Int.MAX_VALUE
        var min_index = -1
        for (v in 0 until V) if (!sptSet[v] && dist[v] <= min) {
            min = dist[v]
            min_index = v
        }
        return min_index
    }

    fun dijkstra(graph: Array<IntArray>, initialPoint: Int): IntArray {
        val dist = IntArray(V)

        val sptSet = Array(V) {false}

        for (i in 0 until V) {
            dist[i] = Int.MAX_VALUE
            sptSet[i] = false
        }

        dist[initialPoint] = 0

        for (count in 0 until V - 1) {

            val u = minDistance(dist, sptSet)

            sptSet[u] = true


            for (v in 0 until V)
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Int.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) dist[v] =
                    dist[u] + graph[u][v]
        }

        return dist
    }
}