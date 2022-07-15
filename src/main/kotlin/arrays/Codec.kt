class Codec {
    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for(i in strs){
            sb.append(i.length)
            sb.append("$")
            sb.append(i)
        }
        return sb.toString()
    }
    
    fun decode(s: String): List<String> {
        var i = 0
        val res = ArrayList<String>()
        while(i < s.length){
            var str = ""
            while(s[i] != '$'){
                str += s[i++]
            }
            val len = str.toInt()
            res.add(s.slice(IntRange(i+1, len+i)))
            i = len+i+1
        }
        return res
    }
}