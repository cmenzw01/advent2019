package advent

import kotlin.math.min

fun main() {
    var noun = 0
    var verb = 0
    var output: Int = 0
    var i = 0

    while (output != 19690720) {
        val codes: IntArray = intArrayOf(1, noun, verb, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 9, 1, 19, 1, 5, 19, 23, 2, 9, 23, 27, 1, 27, 5, 31, 2, 31, 13, 35, 1, 35, 9, 39, 1, 39, 10, 43, 2, 43, 9, 47, 1, 47, 5, 51, 2, 13, 51, 55, 1, 9, 55, 59, 1, 5, 59, 63, 2, 6, 63, 67, 1, 5, 67, 71, 1, 6, 71, 75, 2, 9, 75, 79, 1, 79, 13, 83, 1, 83, 13, 87, 1, 87, 5, 91, 1, 6, 91, 95, 2, 95, 13, 99, 2, 13, 99, 103, 1, 5, 103, 107, 1, 107, 10, 111, 1, 111, 13, 115, 1, 10, 115, 119, 1, 9, 119, 123, 2, 6, 123, 127, 1, 5, 127, 131, 2, 6, 131, 135, 1, 135, 2, 139, 1, 139, 9, 0, 99, 2, 14, 0, 0)
        var instructionPointer = 0
        var action: Action

        while (instructionPointer < codes.size) {
            val instruction = codes.slice(IntRange(instructionPointer, min(instructionPointer + 3, codes.size - 1)))

            val opcode = instruction[0]

            if (opcode == 1) {
                action = Action.ADD
            } else if (opcode == 2) {
                action = Action.MULTIPLY
            } else if (opcode == 99) {
                break
            } else {
                println(codes.asList())
                throw RuntimeException("FAILURE")
            }

            val parameter1 = instruction[1]
            val parameter2 = instruction[2]
            var newValue = 0

            if (action == Action.ADD)
                newValue = codes[parameter1] + codes[parameter2]
            else if (action == Action.MULTIPLY)
                newValue = codes[parameter1] * codes[parameter2]

            val address = instruction[3]
            codes[address] = newValue

            instructionPointer += 4
        }

        output = codes[0]
        val answer = 100 * noun + verb

        println("Noun: $noun and Verb: $verb Output: $output Answer: $answer")

        if (noun < 99) {
            noun++
        } else {
            noun = 0
            verb++
        }
        i++
    }

}

enum class Action {
    ADD,
    MULTIPLY,
    INPUT,
    OUTPUT,
    JUMP_IF_TRUE,
    JUMP_IF_FALSE,
    LESS_THAN,
    EQUALS
}