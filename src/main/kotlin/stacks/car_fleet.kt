package stacks

import java.util.*

class Solution1 {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val posSpeed = MutableList(position.size){0 to 0}
        for(i in 0 until position.size)posSpeed[i] = position[i] to speed[i]
        posSpeed.sortBy{it.first}
        val stk = Stack<Double>()
        for(i in posSpeed.reversed()){
            val time = (target - i.first).toDouble()/i.second
            if(stk.isEmpty())stk.add(time)
            else if(stk.peek() < time)stk.add(time)
        }
        return stk.size
    }
}

fun main(){
    val s = Solution1()
    val position = intArrayOf(10,8,0,5,3)
    val speed = intArrayOf(2,4,1,1,3)
    val t = s.carFleet(12, position, speed)
    print(t)
}