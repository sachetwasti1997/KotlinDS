class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val q = IntArray(nums.size)
        var size = 0
        fun swap(i: Int, j: Int){
            val temp = q[i]
            q[i] = q[j]
            q[j] = temp
        }
        fun insert(data: Int){
            if(size == 0){
                q[size++] = data
                return
            }
            q[size] = data
            var i = size
            while(i > 0 && q[i] > q[(i-1)/2]){
                swap(i, (i-1)/2)
                i = (i-1)/2
            }
            size++
        }
        fun precolateDown(index: Int){
            var large = index
            if(2 * index + 1 < size && q[large] < q[2 * index + 1]) large = 2 * index + 1
            if(2 * index + 2 < size && q[large] < q[2*index + 2]) large = 2 * index + 2
            if(large != index){
                swap(large, index)
                precolateDown(large)
            }
        }       
        fun pop(): Int {
            if(size == 1){
                val t = q[size - 1]
                size = 0
                return t
            }
            val temp = q[0]
            q[0] = q[size-1]
            size--
            precolateDown(0)
            return temp
        }

        for(i in nums){
            insert(i)
        }
        for(i in 0 until k - 1)pop()
        return q[0]
    }
}