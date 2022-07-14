class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anaMap = HashMap<String, ArrayList<String>>()
        for(i in strs){
            val t = HashMap<Char, Int>();
            for(it in i){
                if(map[it] == null)map[it] = 1
                else map[it] = map[it]!! + 1
            }
            val key = map.toString()
            if(anaMap[key] == null)anaMap[key] = ArrayList<String>()
            anaMap[key]?.add(i)
        }
        val resList = mutableListOf<List<String>>()
        for(i in anaMap)resList.add(i.value)
        return resList
    }
}