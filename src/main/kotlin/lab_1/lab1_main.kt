package lab_1

import util.decodeFile
import java.io.File

fun main (){
    val fileContent = decodeFile(File("src/main/resources/matrix_lab1-2.txt"))
    val baseTree = buildMaxBaseTree(fileContent.first, fileContent.second)

    println("Nodes count: ${fileContent.first.size}\n\n" +
            "Original edges count: ${buildEdgesMatrix(fileContent.first, fileContent.second).size}\n" +
            "Original edges:")

    buildEdgesMatrix(fileContent.first, fileContent.second).forEach {
        println("Edge ${it.nodes.first.id + 1} to ${it.nodes.second.id + 1}, weight ${it.weight}")
    }


    println("\nBase tree edges count: ${baseTree.size}\n" +
            "Edges in base tree:")
    baseTree.forEach {
        println("Edge ${it.nodes.first.id + 1} to ${it.nodes.second.id + 1}, weight ${it.weight}")
    }
}