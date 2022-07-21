fun validWordSquare(words: List<String>): Boolean {
        for(i in 0 until words.size){
            for(j in 0 until words[i].length){
                if(j >= words[i].length || i >= words[j].length)return false
                if(words[i][j] != words[j][i])return false
            }
        }
        return true
    }