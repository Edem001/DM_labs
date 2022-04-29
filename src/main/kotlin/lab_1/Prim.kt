package lab_1

import util.Edge
import util.Node

fun buildMaxBaseTree(nodes: List<Node>, weights: List<List<Int>>, firstNodeId: Int = 0): List<Edge> {
    val edges = buildEdgesMatrix(nodes, weights).sortedByDescending { it.weight }.toMutableList()
    val baseTree = mutableListOf<Edge>()

    baseTree += edges.filter { it.nodes.first == nodes[firstNodeId] || it.nodes.second == nodes[firstNodeId] }[0].apply {
        this.nodes.first.checked = true
        this.nodes.second.checked = true

        edges.remove(this)
    }

    while (edges.isNotEmpty()) {
        for (i in edges.indices) {
            if (edges[i].nodes.first.checked xor edges[i].nodes.second.checked) {
                baseTree += edges[i]
                edges[i].nodes.first.checked = true
                edges[i].nodes.second.checked = true

                edges.remove(edges[i])
                break
            } else if (edges[i].nodes.first.checked && edges[i].nodes.second.checked){
                edges.remove(edges[i])
                break
            }
        }
    }

    return baseTree
}

fun buildEdgesMatrix(nodes: List<Node>, weights: List<List<Int>>): List<Edge> {
    val edges = mutableListOf<Edge>()

    weights.forEachIndexed { rowIndex, line ->
        line.forEachIndexed { columnIndex, element ->
            if (element > 0 && columnIndex > rowIndex)
                edges.add(
                    Edge(
                        nodes = nodes[rowIndex] to nodes[columnIndex],
                        weight = element
                    )
                )
        }
    }

    return edges
}