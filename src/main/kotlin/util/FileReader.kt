package util

import java.io.File

fun decodeFile(file: File): Pair<List<Node>, List<List<Int>>>{
    val lines = file.readLines()
    val nodes = List(lines[0].toInt()) { Node(it) }
    val weights: MutableList<List<Int>> = mutableListOf()

    lines.subList(1, lines.size).forEach {line ->
        weights.add(line.split(" ").map { it.toInt() })
    }

    return nodes to weights
}