import java.util.HashMap;
class Solution {
    public int solution(String s) {
        String answer="";
        String temp="";
        for (int i=0;i<s.length();i++){
            //System.out.println(s.charAt(i));
            temp+=s.charAt(i);
            String res=check(temp);
            if(res.equals("")){
               continue;
            }
            else{
                temp="";
                answer+=res;
            }
        }
        
        return Integer.parseInt(answer);
    }
    //숫자(0~9)나 (one~nine)이면 숫자로 바꿔서 반환
    public String check(String temp){
        String res="";
        if (temp.equals("0") || temp.equals("zero")){
            res="0";
        }
        else if(temp.equals("1") || temp.equals("one")){
            res="1";
        }
        else if(temp.equals("2") || temp.equals("two")){
            res="2";
        }
        else if(temp.equals("3") || temp.equals("three")){
            res="3";
        }
        else if(temp.equals("4") || temp.equals("four")){
            res="4";
        }
        else if(temp.equals("5") || temp.equals("five")){
            res="5";
        }
        else if(temp.equals("6") || temp.equals("six")){
            res="6";
        }
        else if(temp.equals("7") || temp.equals("seven")){
            res="7";
        }
        else if(temp.equals("8") || temp.equals("eight")){
            res="8";
        }
        else if(temp.equals("9") || temp.equals("nine")){
            res="9";
        }
        
        return res;
    }
}

