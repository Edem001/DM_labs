package util

data class Node(
    val id: Int,
    var checked: Boolean = false
)

data class Edge(
    val nodes: Pair<Node, Node>,
    val weight: Int
)