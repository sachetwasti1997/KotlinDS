/* The knows API is defined in the parent class Relation.
      fun knows(a: Int, b: Int) : Boolean {} */

class Solution: Relation() {
    override fun findCelebrity(n: Int) : Int {
        val noCele = HashSet<Int>()
        for(i in 0 until n){
            for(j in 0 until n){
                if(j == i )continue
                if(knows(i,j)){
                    noCele.add(i)
                }else{
                    noCele.add(j)
                }
            }
        }
        for(i in 0 until n){
            if(!noCele.contains(i))return i
        }
        return -1
	}
}