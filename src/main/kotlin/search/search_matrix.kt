class Solution {
    fun searchMatrix(mt: Array<IntArray>, t: Int): Boolean {
    val R = mt.size
    val C = mt[0].size
    var m = 0
    var n = C - 1
    while(m < R && n >= 0){
        if(mt[m][n] == t)return true
        else if(mt[m][n] > t){
            n--
        }
        else if(mt[m][n] < t){
            m++
        }
    }
    return false
}
}