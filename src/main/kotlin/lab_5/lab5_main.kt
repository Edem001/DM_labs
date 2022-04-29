package lab_5

import util.decodeFile
import java.io.File


val graph1 = decodeFile(File("src/main/resources/matrix_lab5-1.txt")).second.map { it.toIntArray() }.toTypedArray()
val graph2 = decodeFile(File("src/main/resources/matrix_lab5-2.txt")).second.map { it.toIntArray() }.toTypedArray()

val N = graph1.size

val K_reference = graph1.indices.toList().toIntArray()
lateinit var K: IntArray

fun graph_isomorph(): Boolean {
    for (i in 0 until N)
    for (j in 0 until N)
    if (graph1[i][j] != graph2[K[i]][K[j]])
        return false
    return true
}

fun printGraph(){
    println("Матриця суміжності для графа 1")

    graph1.forEach {line ->
        line.forEach {
            print("$it ")
        }
        println()
    }

    println("Матриця суміжності для графа 2")

    graph2.forEach {line ->
        line.forEach {
            print("$it ")
        }
        println()
    }

}

fun main() {
    printGraph()
    println("\n")
    allPermutations(K_reference.toSet()).forEach {
        K = it.toIntArray()
        if (graph_isomorph()) {
            println("Задані графи ізоморфні");
            println("Відповідні вершини графів:");
            K.forEachIndexed { index, i ->
                println("${index + 1} : ${i + 1}")
            }
        }
    }
}
