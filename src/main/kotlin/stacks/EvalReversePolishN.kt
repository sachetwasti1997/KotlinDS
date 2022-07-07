package stacks

import java.util.*

class Solution0 {
    fun evalRPN(tokens: Array<String>): Int {
        val stk = Stack<Int>()
        for(i in tokens){
            if(i == "*"){
                val p = stk.pop()
                val q = stk.pop()
                stk.push(p * q)
            }else if(i == "+"){
                val p = stk.pop()
                val q = stk.pop()
                stk.push(p + q)
            }else if(i == "-"){
                val p = stk.pop()
                val q = stk.pop()
                stk.push(q - p)
            }else if(i == "-"){
                val p = stk.pop()
                val q = stk.pop()
                stk.push(q / p)
            }else {
                stk.push(i.toInt())
            }
        }
        return stk.pop()
    }
}