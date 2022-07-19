class BrowserHistory(homepage: String) {

    class History(val url: String, var prev: History? = null, var next: History? = null)
    var cp: History ?= null
    var head: History? = null
    
    init {
        val p = History(homepage) 
        head = p
        cp = p
    }
    
    fun visit(url: String) {
        val p = History(url)
        cp?.next = p
        p.prev = cp
        cp = p
    }

    fun back(steps: Int): String {
        var stp = steps
        while(cp?.prev != null && stp > 0){
            cp = cp?.prev
            stp--
        }
        return cp?.url ?: ""
    }

    fun forward(steps: Int): String {
        var stp = steps
        while(cp?.next != null && stp > 0){
            cp = cp?.next
            stp--
        }
        return cp?.url ?: ""
    }

}