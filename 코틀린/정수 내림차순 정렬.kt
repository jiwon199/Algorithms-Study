class Solution {
    fun solution(n: Long): Long {
        var array=emptyArray<Char>()
        var answer=""
        var num=n.toString()
        for (i in 0..num.length-1){
            array=array.plus(num[i])
        }
        array.sortDescending()
        for (a in array){
            answer+=a
        }
        return answer.toLong()
    }
}
