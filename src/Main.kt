import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.test.assertEquals

import kotlin.ranges.*

// Complete the balancedSums function below.
fun balancedSums(arr: Array<Int>): String {

    var index = arr.size.shr(1)
    var leftSum = 0
    for (i in 0 until index) {
        leftSum += arr[i]
    }
    var rightSum = 0
    for (i in index + 1 until arr.size) {
        rightSum += arr[i]
    }
    var leftWasLower = 0
    var rightWasLower = 0

    while (true) {
        when {
            leftSum < rightSum -> {
                if (rightWasLower > 1) return "NO"
                index++
                if (index >= arr.size) return "NO"

                leftSum += arr[index - 1]
                rightSum = if (index == arr.size - 1) 0 else rightSum - arr[index]
                leftWasLower++
            }
            leftSum > rightSum -> {
                if (leftWasLower > 1) return "NO"
                index--
                if (index < 0) return "NO"
                rightSum += arr[index + 1]
                leftSum -= arr[index]
                rightWasLower++
            }
            else -> return "YES"
        }
    }
}

fun main(args: Array<String>) {
    assertEquals("NO", balancedSums(arrayOf(1, 2, 3)))
    assertEquals("YES", balancedSums(arrayOf(1, 2, 3, 3)))
    assertEquals("YES", balancedSums(arrayOf(1, 1, 4, 1, 1)))
    assertEquals("YES", balancedSums(arrayOf(1, 1, 4, 1, 1)))
    assertEquals("YES", balancedSums(arrayOf(0, 0, 2, 0)))
    assertEquals("YES", balancedSums(arrayOf(0, 2, 0)))
    assertEquals("NO", balancedSums(arrayOf(0, 2, 1)))
    assertEquals("NO", balancedSums(arrayOf(8, 2, 1)))
    assertEquals("YES", balancedSums(arrayOf(8, 2, 1, 7)))
    assertEquals("YES", balancedSums(arrayOf(1)))
    assertEquals("YES", balancedSums(arrayOf(5, 6, 8, 11)))
    assertEquals("YES", balancedSums(arrayOf(2, 0, 0, 0)))
    assertEquals("YES", balancedSums(arrayOf(0, 0, 0, 2)))
    assertEquals("YES", balancedSums(arrayOf(8, 3, 1, 7)))
    assertEquals("NO", balancedSums(arrayOf(8, 1, 3, 1, 7)))
    assertEquals("NO", balancedSums(arrayOf(9, 3, 1, 7)))


    val arr0 =
        "75 26 45 72 81 47 29 97 2 75 25 82 84 17 56 32 2 28 37 57 39 18 11 79 6 40 68 68 16 40 63 93 49 91 10 55 68 31 80 57 18 34 28 76 55 21 80 22 45 11 67 67 74 91 4 35 34 65 80 21 95 1 52 25 31 2 53 96 22 89 99 7 66 32 2 68 33 75 92 84 10 94 28 54 12 9 80 43 21 51 92 20 97 7 25 67 17 38 100 86"
            .split(" ").map { it.toInt() }.toTypedArray()

    assertEquals("NO", balancedSums(arr0))

    val arr1 =
        "83 20 6 81 58 59 53 2 54 62 25 35 79 64 27 49 32 95 100 20 58 39 92 30 67 89 58 81 100 66 73 29 75 81 70 55 18 28 7 35 98 52 30 11 69 48 84 54 13 14 15 86 34 82 92 26 8 53 62 57 50 31 61 85 88 5 80 64 90 52 47 43 40 93 69 70 16 43 7 25 99 12 63 99 71 76 55 17 90 43 27 20 42 84 39 96 75 1 58 49"
            .split(" ").map { it.toInt() }.toTypedArray()
    assertEquals("NO", balancedSums(arr1))

    val arr2 =
        "185 170 208 216 236 155 88 206 211 209 84 99 130 245 232 125 127 232 187 140 92 213 221 231 129 197 221 168 95 186 136 180 94 125 150 244 249 248 140 207 125 84 123 85 100 175 67 116 107 143 158 75 165 172 115 134 175 123 115 123 159 181 63 176 158 109 67 154 126 141 111 95 138 161 71 118 151 189 126 109 194 176 159 151 189 71 95 133 154 157 109 78 101 174 169 152 94 193 176 137"
            .split(" ").map { it.toInt() }.toTypedArray()
    assertEquals("YES", balancedSums(arr2))

    val arr3 =
        "9 79 79 61 14 23 44 100 94 47 20 52 63 74 29 84 30 22 65 46 85 91 53 5 10 53 56 43 94 54 97 75 31 74 20 37 95 45 54 73 6 65 24 52 31 29 53 31 92 27 13 81 38 63 58 58 66 1 95 74 7 51 68 78 9 4 7 8 92 99 50 6 99 22 98 15 81 67 82 37 19 11 26 44 88 26 44 2 88 44 55 21 89 46 31 16 45 54 34 22"
            .split(" ").map { it.toInt() }.toTypedArray()
    assertEquals("NO", balancedSums(arr3))

    val arr4 =
        "83 42 26 41 86 1 61 32 61 68 3 76 58 72 66 59 24 36 41 54 18 25 95 49 25 56 50 78 11 83 84 90 59 45 45 68 22 1 55 72 85 75 12 65 21 20 96 16 57 49 48 7 35 91 84 82 68 98 74 41 39 93 17 3 34 68 71 65 21 83 3 66 49 32 76 88 38 64 36 73 70 22 74 32 60 55 48 80 61 89 54 20 34 33 45 90 40 12 17 35"
            .split(" ").map { it.toInt() }.toTypedArray()
    assertEquals("NO", balancedSums(arr4))

    val arr5 =
        "31 59 49 55 48 46 47 33 47 25 49 34 52 35 46 55 44 53 56 34 38 36 41 49 55 38 42 20 22 33 43 51 28 44 45 25 19 19 18 32 27 33 15 13 29 29 30 18 27 12 15 19 14 28 18 22 26 18 28 21 27 23 24 17 32 21 30 34 27 15 30 31 31 14 19 26 18 15 29 23 16 12 31 23 30 17 31 20 32 28 23 29 18 27 31 16 12 15 28 28"
            .split(" ").map { it.toInt() }.toTypedArray()
    assertEquals("YES", balancedSums(arr5))

    val arr6 =
        "31 27 35 21 33 15 13 17 27 29 23 31 31 30 25 26 30 34 19 25 28 22 33 19 28 22 20 12 22 26 27 16 22 34 25 13 14 24 34 18 15 21 16 27 13 13 20 14 33 27 34 14 30 33 21 25 18 14 16 29 29 13 20 26 16 23 23 28 16 32 29 23 33 15 15 26 34 31 14 31 12 17 35 113 149 134 84 100 139 107 97 98 73 74 83 104 143 141 130 151"
            .split(" ").map { it.toInt() }.toTypedArray()
    assertEquals("YES", balancedSums(arr6))
}