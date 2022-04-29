import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";         
        String temp = new_id.toLowerCase();
        String id="";
        for (int i=0;i<new_id.length();i++){
           // new_id.charAt(i)
            char ch=temp.charAt(i);
            if (Character.isDigit(ch)){
                id+=ch;
            }
            else if(Character.isLowerCase(ch)){
                id+=ch;
            }
            else if(ch=='.' || ch=='_' || ch=='-'){
                id+=ch;
            }
        }
        //char before=id.charAt(0);
        String id2="";
        id2+=id.charAt(0);   
        for(int i=1;i<id.length();i++){
            int n=id2.length();
            if (id2.charAt(n-1)=='.' && id.charAt(i)=='.'){
                continue;
            }
            else{
                id2+=id.charAt(i);
            }
            
        }
        
        String id3="";
        for(int i=0;i<id2.length();i++){
            if (i==0 &&id2.charAt(i)=='.'){
                continue;
            }
            else if(i==id2.length()-1 &&id2.charAt(i)=='.'){
                continue;
            }
            else{
                id3+=id2.charAt(i);
            }
        }
         
        if (id3.length()==0){
            return "aaa";
        }
        if(id3.length()>=16){          
            if (id3.charAt(14)=='.'){
                answer=id3.substring(0,14);
            }
            else{
                answer=id3.substring(0,15);
            }
        }
        else{
            answer=id3;
        }
        int n=answer.length();
        char end=answer.charAt(n-1);
        while(answer.length()<=2){
            answer+=end;
        }
        //System.out.println(answer+n);
        
        return answer;
    }
}
