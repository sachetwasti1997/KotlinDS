package stacks

import java.util.*

class MinStack() {

    val stk = Stack<Pair<Int, Int>>()

    fun push(`val`: Int) {
        if(stk.isEmpty())stk.push(`val` to `val`)
        else{
            var min = `val`
            if(min > stk.peek().second)min = stk.peek().second
            stk.add(`val` to min)
        }
    }

    fun pop() {
        stk.pop()
    }

    fun top(): Int {
        return stk.pop().first
    }

    fun getMin(): Int {
        return stk.pop().second
    }

}

fun main(){
    val minS = MinStack()
    minS.push(-2)
    minS.push(0)
    minS.push(-3)
}
