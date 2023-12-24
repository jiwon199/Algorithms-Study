class Solution {
    public String solution(int[] food) {
        String str = "";
        for(int i=1;i<food.length;i++){
            int n=food[i]/2;

            for(int j=0;j<n;j++){
                str+=String.valueOf(i);
            }
        }
        StringBuffer sb = new StringBuffer(str);
        String answer=str+"0"+sb.reverse().toString();
        
        return answer;
    }
}
