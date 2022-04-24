class Solution {
    fun solution(num: Int): Int {         
        var count=0
        var n=num.toLong()
        while(true){
            if (count==500){
                count=-1
                break
            }
            if (n==1.toLong()){
                break
            }
            
            if(n%2==0.toLong()){
                n=n/2 
            }
            else{
                n=n*3+1
            }
            count+=1
        }
        
        return count
    }
}
