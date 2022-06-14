package Graphs

import java.util.Arrays

fun replaceAll0Sorrounded1(charArr: Array<CharArray>){
    val R = charArr.size
    val C = charArr[0].size
    for (i in charArr.indices){
        for (j in charArr[0].indices){
            if (charArr[i][j] == '1'){
                if (i == 0){
                    if (j == 0){
                        charArr[i][j] = if(charArr[i+1][j] == '0' || charArr[i][j+1] == '0')'b' else charArr[i][j]
                    }else if (j == C-1){
                        charArr[i][j] = if(charArr[i+1][j] == '0' || charArr[i][j-1] == '0')'b' else charArr[i][j]
                    }else{
                        charArr[i][j] = if (charArr[i+1][j] == '0' || charArr[i][j+1] == '0' || charArr[i][j-1] == '0')'b' else charArr[i][j]
                    }
                }
                else if (j == 0){
                    if (i == R-1){
                        charArr[i][j] = if(charArr[i-1][j] == '0' || charArr[i][j+1] == '0')'b' else charArr[i][j]
                    }else{
                        charArr[i][j] = if(charArr[i-1][j] == '0' || charArr[i][j+1] == '0' || charArr[i+1][j] == '0')'b' else charArr[i][j]
                    }
                }
                else if(j == C-1){
                    if (i == R-1){
                        charArr[i][j] = if(charArr[i-1][j] == '0' || charArr[i][j-1] == '0')'b' else charArr[i][j]
                    }else{
                        charArr[i][j] = if(charArr[i-1][j] == '0' || charArr[i][j-1] == '0' || charArr[i+1][j] == '0')'b' else charArr[i][j]
                    }
                }
                else if(i == R-1){
                    charArr[i][j] = if(charArr[i-1][j] == '0' || charArr[i][j-1] == '0' || charArr[i][j+1] == '0')'b' else charArr[i][j]
                }else{
                    charArr[i][j] = if(charArr[i-1][j] == '0' || charArr[i][j-1] == '0' || charArr[i][j+1] == '0' || charArr[i+1][j] == '0')'b' else charArr[i][j]
                }
            }
        }
    }
}

fun main(){
    var charArr = arrayOf(
        charArrayOf('0', '0', '0', '0', '0', '0', '0', '0'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '0'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '1'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '0'),
        charArrayOf('0', '1', '1', '1', '1', '1', '1', '0'),
        charArrayOf('0', '0', '1', '0', '0', '0', '0', '0')
    )
    replaceAll0Sorrounded1(charArr)
    Arrays.stream(charArr).forEach {
        println(Arrays.toString(it))
    }
}