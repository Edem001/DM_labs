package lab_4

import util.decodeFile
import java.io.File

val graph = decodeFile(File("src/main/resources/matrix_lab4-1.txt"))
val V = graph.first.size

fun main() {
    graph.second.forEach {
        println(it)
    }

    println(
        "The maximum possible flow is ${
            fordFulkerson(graph.second.map { it.toIntArray() }.toTypedArray(), 0, graph.first.lastIndex)
        }"
    )
}


