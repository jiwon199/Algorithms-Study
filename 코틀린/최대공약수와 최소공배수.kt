class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var answer = intArrayOf()
        //answer=answer.plus(1)
        var num=n
        if (n>m){
            num=m
        }
        for(i in num downTo 1){
            if ((n%i==0)and (m%i==0)){
                answer=answer.plus(i)
                break
            }
        }
        for(i in 1..n*m){
            if ((i%n==0)and (i%m==0)){
                answer=answer.plus(i)
                break
            }
        }
        return answer
    }
}
