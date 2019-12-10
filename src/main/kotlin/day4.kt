package advent

fun main() {
    val min = 235741
    val max = 706948

    var validCount = 0

    for (i in min..max) {
        val chars = i.toString().toCharArray()
        if (has2SameAdjacentNumbers(chars) && increases(chars)) {
            validCount ++
        }
    }

    println("Valid password count: $validCount")
}

fun has2SameAdjacentNumbers(chars: CharArray): Boolean {
    for (i in 0..chars.size - 2) {
        if (chars[i] == chars[i + 1] && (i == 0 || chars[i - 1] != chars[i]) && (i == chars.size - 2 || chars[i + 2] != chars[i])) {
            return true
        }
    }
    return false
}

fun increases(chars: CharArray): Boolean {
    for (i in 0..chars.size - 2) {
        if (chars[i] > chars[i + 1]) {
            return false
        }
    }
    return true
}