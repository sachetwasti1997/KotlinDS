//     fun generate(numRows: Int): List<List<Int>> {
//     val res = ArrayList<MutableList<Int>>(numRows)
//     for(i in 1 .. numRows){
//         val l = IntArray(i){1}.toMutableList()
//         res.add(l)
//     }
//     if(numRows == 1 || numRows == 2)return res
//     for(i in 2 until numRows){
//         for(j in 1 until res[i].size - 1){
//             res[i][j] = res[i-1][j-1] + res[i-1][j]
//         }
//     }
//     return res
// }
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>(numRows)
        var pre = ArrayList<Int>()
        var row = ArrayList<Int>()
        var size = 1
        for(i in 0 until numRows){
            for(j in 0 until size){
                if(j == 0 || j == size-1)row.add(1)
                else{
                    row.add(pre[j-1]+pre[j])
                }
            }
            pre = ArrayList(row)
            res.add(pre)
            row = ArrayList<Int>(++size)
        }      
        return res
    }
}