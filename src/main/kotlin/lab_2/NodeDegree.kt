package lab_2

import util.Node

fun getNodesDegree(nodes: List<Node>, weights: List<List<Int>>): IntArray {
    val degrees = IntArray(nodes.size)

    for (i in weights.indices) {
        var counter = 0
        for (k in weights[i].indices) {
            if (weights[i][k] > 0) counter++
        }

        degrees[i] = counter
    }

    return degrees
}