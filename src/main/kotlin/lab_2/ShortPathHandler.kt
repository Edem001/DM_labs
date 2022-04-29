package lab_2

import util.Edge as Path
import util.Node

fun shortPath(nodes: List<Node>, weights: List<List<Int>>, degrees: List<Int>): List<Path> {
    val nonDualList = mutableListOf<Int>()
    degrees.forEachIndexed { index, i -> if (i % 2 != 0) nonDualList.add(index)}

    val pathList = mutableListOf<Path>()

    val dijkstra = Dijkstra(nodes.size)
    while (nonDualList.isNotEmpty()) {
        val paths = dijkstra.dijkstra(weights.map { it.toIntArray() }.toTypedArray(), nonDualList.first())
            .map { if (it == 0) Int.MAX_VALUE else it }

        val pathsToNonDouble = paths.filterIndexed { index, _ -> index in nonDualList }.sorted()

        val currentIndex = nonDualList.first().also { nonDualList.remove(nonDualList.first()) }
        val secondIndex = paths.indexOf(pathsToNonDouble.first())

        pathList += Path(nodes[currentIndex] to nodes[secondIndex], pathsToNonDouble.first())
        nonDualList -= currentIndex
        nonDualList -= secondIndex
    }

    return pathList
}