class Solution {
    fun solution(x: Int): Boolean {
        var num=0
        var ori=x
        while(ori>0){
            num+=ori%10
            ori=ori/10
        }
        
        return (x % num == 0)
        
    }
}
