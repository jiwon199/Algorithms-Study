import java.util.*;
class Solution {
    int [] output;
    int n,answer;
    int [] number;
    public int solution(int[] number) {
        answer = 0;
        output=new int[3];
        n=number.length;
        this.number=number;
        combi(0,0);
        return answer;
    }
    public void combi(int start,int depth){
        if(depth==3){
            if(isAnswer(output)) answer++;
            return;
        }
        for(int i=start;i<n;i++){
            output[depth]=i;
            combi(i+1,depth+1);
        }
    }
    public boolean isAnswer(int [] output){
        if(number[output[0]]+number[output[1]]+number[output[2]]==0){
            return true;
        }
        return false;
    }
}
