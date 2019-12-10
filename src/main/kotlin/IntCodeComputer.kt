package advent

import kotlin.math.min
import kotlinx.coroutines.channels.*

class IntCodeComputer(val name: String, val codes: IntArray) {

    val outputs: Channel<Int> = Channel(10)
    val done: Channel<Int> = Channel(10)

    suspend fun execute(inputs: Channel<Int>) {
        var instructionPointer = 0
        var action: Action

        while (instructionPointer < codes.size) {
            var incrementPointer = true
            val op = codes[instructionPointer].toString()
            var opcode = op.toInt()
            if (opcode.toString().length > 1) {
                opcode = op.substring(
                    codes[instructionPointer].toString().length - 2,
                    codes[instructionPointer].toString().length
                ).toInt()
            }

            var instructionSize: Int

            if (opcode == 1) {
                action = Action.ADD
                instructionSize = 4
            } else if (opcode == 2) {
                action = Action.MULTIPLY
                instructionSize = 4
            } else if (opcode == 3) {
                action = Action.INPUT
                instructionSize = 2
            }  else if (opcode == 4) {
                action = Action.OUTPUT
                instructionSize = 2
            }  else if (opcode == 5) {
                action = Action.JUMP_IF_TRUE
                instructionSize = 3
            }  else if (opcode == 6) {
                action = Action.JUMP_IF_FALSE
                instructionSize = 3
            }  else if (opcode == 7) {
                action = Action.LESS_THAN
                instructionSize = 4
            }  else if (opcode == 8) {
                action = Action.EQUALS
                instructionSize = 4
            } else if (opcode == 99) {
                done.send(1)
                println("$name done!")
                break
            } else {
                println(codes.asList())
                throw RuntimeException("INVALID opcode $opcode")
            }

            val instruction = codes.slice(IntRange(instructionPointer, min(instructionPointer + instructionSize - 1, codes.size - 1)))

            var parameter1 = 0
            if (op.toCharArray().size > 2 && op.toCharArray()[op.toCharArray().size - 3].toString().toInt() == 1) {
                parameter1 = instruction[1]
            } else {
                parameter1 = codes[instruction[1]]
            }

            var parameter2 = 0
            if (instruction.size > 2 && op.toCharArray().size > 3 && op.toCharArray()[op.toCharArray().size - 4].toString().toInt() == 1) {
                parameter2 = instruction[2]
            } else if (instruction.size > 2) {
                parameter2 = codes[instruction[2]]
            }

            var newValue = 0

            if (action == Action.ADD) {
                newValue = parameter1 + parameter2
                val address = instruction[3]
                codes[address] = newValue
            } else if (action == Action.MULTIPLY) {
                newValue = parameter1 * parameter2
                val address = instruction[3]
                codes[address] = newValue
            } else if (action == Action.INPUT) {
                val address = instruction[1]
                println("$name is awaiting input")
                val input = inputs!!.receive()
                codes[address] = input
                println("$name received input $input")
//                inputs = inputs.drop(1).toIntArray()
            } else if (action == Action.OUTPUT) {
//                println(parameter1)
//                return parameter1
//                output = parameter1
                println("$name is sending output $parameter1")
                outputs!!.send(parameter1)
            } else if ((action == Action.JUMP_IF_TRUE && parameter1 != 0) || (action == Action.JUMP_IF_FALSE && parameter1 == 0)) {
                instructionPointer = parameter2
                incrementPointer = false
            } else if (action == Action.LESS_THAN) {
                codes[instruction[3]] = if (parameter1 < parameter2) 1 else 0
            } else if (action == Action.EQUALS) {
                codes[instruction[3]] = if (parameter1 == parameter2) 1 else 0
            }

            if (incrementPointer) {
                instructionPointer += instructionSize
            }
        }
    }
}