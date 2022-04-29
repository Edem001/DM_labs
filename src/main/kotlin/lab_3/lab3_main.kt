package lab_3

import util.decodeFile
import java.io.File

val adj = decodeFile(File("src/main/resources/matrix_lab3-1.txt"))
val N = adj.first.size
var final_path = IntArray(N + 1)
var visited = BooleanArray(N) { false }
var final_res = Int.MAX_VALUE

fun main() {
    adj.second.forEach { line ->
        println(line)
    }

    tsp(adj.second.map { it.toIntArray() }.toTypedArray())
    System.out.printf("Minimum cost : %d\n", final_res)
    System.out.printf("Path Taken : ")
    for (i in 0..N) {
        System.out.printf("%d ", final_path[i])
    }
}






