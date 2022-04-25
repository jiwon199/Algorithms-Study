class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        var s=arr1[0].size
        
        for (i in 0..arr1.size-1){
            var array=IntArray(s)
            for (j in 0..s-1){
                array[j]=arr1[i][j]+arr2[i][j]
            }
            answer=answer.plus(array)
        }
                
        return answer
    }
}
