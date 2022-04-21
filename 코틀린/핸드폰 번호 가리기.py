class Solution {
    fun solution(phone_number: String): String {
        var answer=""
        val n=phone_number.length
        for (i in 0..n-5){
            answer+="*"
        }
        answer+=phone_number.slice(n-4..n-1)
        
        return answer
    }
}
