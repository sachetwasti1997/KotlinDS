import java.util.*

class Solution22 {
    // fun totalSteps(nums: IntArray): Int {
    //     var list = LinkedList<Int>()
    //     for(i in nums)list.add(i)
    //     var count = 0
    //     var t = false
    //     while(!t){
    //         val newList = LinkedList<Int>()
    //         var prev = 0
    //         for(i in list){
    //             if(i >= prev)newList.add(i)
    //             prev = i
    //         }
    //         if(newList.size == list.size)break
    //         count++
    //         list = LinkedList(newList)
    //     }
    //     return count
    // }
    // fun totalSteps(nums: IntArray):Int{
    //     var l = nums.toMutableList()
    //     var count = 0
    //     while(true){
    //         val newl = mutableListOf<Int>()
    //         var prev = 0
    //         for(i in l){
    //             if(prev <= i)newl.add(i)
    //             prev = i
    //         }
    //         if(newl.size == l.size)return count
    //         count++
    //         l = newl
    //     }
    //     return count
    // }

    fun totalSum(nums:IntArray): Int{
        var l = Stack<Int>()
        var count = 0
        var prev = 0
        for(i in nums.reversed()){
            if(i <= l.peek())l.add(i)
            else{
                count = Math.max(count, l.size)
                l = Stack<Int>()
                l.add(i)
            }
        }
        return count
    }

}

fun main(){
    val t = IntArray(10){5}
    val m = mutableListOf<Int>(10)
}