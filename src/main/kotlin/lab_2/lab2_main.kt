package lab_2

import util.decodeFile
import java.io.File

fun main() {
    val fileInput = decodeFile(File("src/main/resources/matrix_lab2-3.txt"))
    val degrees = getNodesDegree(fileInput.first, fileInput.second)
    val matrixType = !degrees.any { it % 2 != 0 }

    println("Matrix: ")
    fileInput.second.forEach {
        println(it)
    }

    println("Vertices: ${fileInput.first.size}")

    println("Vertices degrees: ${degrees.contentToString()}\n" +
            "Matrix type: ${if(matrixType) "DUAL" else "NOT DUAL"}")

    val weightsSum = fileInput.second.flatten().sum().div(2)
    val nonPairAppendix = shortPath(fileInput.first, fileInput.second, degrees.toList())

    println("Shortest way: ${weightsSum + if(!matrixType) nonPairAppendix.sumOf { it.weight } else 0}")


}