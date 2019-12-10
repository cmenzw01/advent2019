package advent

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*


fun main() {
    val codes = intArrayOf(3,8,1001,8,10,8,105,1,0,0,21,42,67,76,89,110,191,272,353,434,99999,3,9,102,2,9,9,1001,9,2,9,1002,9,2,9,1001,9,2,9,4,9,99,3,9,1001,9,4,9,102,4,9,9,101,3,9,9,1002,9,2,9,1001,9,4,9,4,9,99,3,9,102,5,9,9,4,9,99,3,9,1001,9,3,9,1002,9,3,9,4,9,99,3,9,102,3,9,9,101,2,9,9,1002,9,3,9,101,5,9,9,4,9,99,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,99,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,99)
//    val codes = intArrayOf(3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,
//        -5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,
//        53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10)

    var maxSignal = 0
//    val phases = intArrayOf(0,1,2,3,4)
    val phases = intArrayOf(5,6,7,8,9)
    val phaseSettings = permute(phases)

    for (phaseSetting in phaseSettings) {
        val a = IntCodeComputer("a", codes.clone())
        val b = IntCodeComputer("b", codes.clone())
        val c = IntCodeComputer("c", codes.clone())
        val d = IntCodeComputer("d", codes.clone())
        val e = IntCodeComputer("e", codes.clone())

        val computers = arrayListOf(a,b,c,d,e)

        GlobalScope.launch {
            println("setting outputs")
            e.outputs.send(phaseSetting[0])
            e.outputs.send(0)
            a.outputs.send(phaseSetting[1])
            b.outputs.send(phaseSetting[2])
            c.outputs.send(phaseSetting[3])
            d.outputs.send(phaseSetting[4])
        }

        println("executing")
        computers.withIndex().forEach {
            GlobalScope.launch {
                val outputIndex = if (it.index == 0) computers.size - 1 else it.index - 1
                it.value.execute(computers[outputIndex].outputs)
            }
        }

        runBlocking {
            println("waiting on done")
            e.done.receive()
            val output = e.outputs.receive()
            println("received output: $output")
            if (output > maxSignal) {
                maxSignal = output
            }
        }
    }
    println("Max thruster signal: $maxSignal")
}

private fun permute(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    helper(0, nums, result)
    return result
}

private fun helper(start: Int, nums: IntArray, result: MutableList<List<Int>>) {
    if (start == nums.size - 1) {
        val list = ArrayList<Int>()
        for (num in nums) {
            list.add(num)
        }
        result.add(list)
        return
    }
    for (i in start until nums.size) {
        swap(nums, i, start)
        helper(start + 1, nums, result)
        swap(nums, i, start)
    }
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}
