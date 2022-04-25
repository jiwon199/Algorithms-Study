import kotlin.math.*
class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        if (arr.size==1){
            answer=answer.plus(-1)
        }
        else{     
            var min = Int.MAX_VALUE
            for(i in arr) {
                if(i < min) min = i
            }
            for (i in arr){
                if (i!=min){
                    answer=answer.plus(i)
                }
            }
        }
        return answer
    }
}
