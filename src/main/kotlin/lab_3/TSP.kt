package lab_3

import java.util.*

fun tsp(adj: Array<IntArray>) {
    val curr_path = IntArray(N + 1)

    var curr_bound = 0
    Arrays.fill(curr_path, -1)
    Arrays.fill(visited, false)

    for (i in 0 until N) curr_bound += findMins(adj, i).first + findMins(adj, i).second

    curr_bound = if (curr_bound == 1) 1 else curr_bound / 2


    visited[0] = true
    curr_path[0] = 0


    tspSolve(adj, curr_bound, 0, 1, curr_path)
    final_path = final_path.map { if (it < 0) 0 else it }.toIntArray()
}

fun tspSolve(
    adj: Array<IntArray>, curr_bound: Int, curr_weight: Int,
    level: Int, curr_path: IntArray
) {
    var curr_bound = curr_bound
    var curr_weight = curr_weight
    if (level == N) {
        if (adj[curr_path[level - 1]][curr_path[0]] != 0) {
            val curr_res = curr_weight +
                    adj[curr_path[level - 1]][curr_path[0]]

            if (curr_res < final_res) {
                final_path = curr_path.clone()
                final_res = curr_res
            }
        }
        return
    }

    for (i in 0 until N) {

        if (adj[curr_path[level - 1]][i] != 0 && !visited[i]
        ) {
            val temp = curr_bound
            curr_weight += adj[curr_path[level - 1]][i]

            curr_bound -=
                if (level == 1) (findMins(adj, curr_path[0]).second + findMins(adj, i).first) / 2
                else (findMins(adj, curr_path[level - 1]).second + findMins(adj, i).first) / 2

            if (curr_bound + curr_weight < final_res) {
                curr_path[level] = i
                visited[i] = true

                tspSolve(
                    adj, curr_bound, curr_weight, level + 1,
                    curr_path
                )
            }

            curr_weight -= adj[curr_path[level - 1]][i]
            curr_bound = temp

            Arrays.fill(visited, false)
            for (j in 0 until level) visited[curr_path[j]] = true
        }
    }
}

