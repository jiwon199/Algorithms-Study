import java.util.*;
class Solution {
   static Map <String,Integer> term=new HashMap<>();
    static Map <Integer,String> res=new HashMap<>();
    static  List<Integer> list=new ArrayList<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        for(String info:terms){
            String [] infos=info.split(" ");
            term.put(infos[0],Integer.parseInt(infos[1]));
        }

       for(int i=1;i<=privacies.length;i++){
           String [] infos=privacies[i-1].split(" ");
           res.put(i,findTerm(infos[0],term.get(infos[1])));
           
       }
    
       for(int i=1;i<=privacies.length;i++){
           
           String [] date=res.get(i).split("[.]");
           String [] todayD=today.split("[.]");
           
           if(Integer.parseInt(date[0])<Integer.parseInt(todayD[0])){
               list.add(i);
           }
           else if(Integer.parseInt(date[0])==Integer.parseInt(todayD[0])){
               if(Integer.parseInt(date[1])<Integer.parseInt(todayD[1])){
                   list.add(i);
               }
               else if(Integer.parseInt(date[1])==Integer.parseInt(todayD[1])){
                    
                   if(Integer.parseInt(date[2])<Integer.parseInt(todayD[2])){
                       list.add(i);
                   }
               }
           }  

       }
         
       int size=list.size();
       int [] ans=new int[size];
       for(int i=0;i<size;i++){
           ans[i]=list.get(i);
       }
       return ans;
    }
    static String findTerm(String regist,int term){
        String [] dates=regist.split("[.]");
         int y=term/12;
        int m=term%12;
        int newY=Integer.parseInt(dates[0])+y;
        int newM=Integer.parseInt(dates[1])+m;
        if(newM==0) newM=Integer.parseInt(dates[1]);
        if(newM>12){
            newM=newM%12;
            newY++;
        }

        if(Integer.parseInt(dates[2])==1){
            if(newM==1){
                return String.valueOf(newY-1)+".12.28";
            }
            else
                return String.valueOf(newY)+"."+String.valueOf(newM-1)+"."+"28";
        }
        else
            return String.valueOf(newY)+"."+String.valueOf(newM)+"."+String.valueOf(Integer.parseInt(dates[2])-1);
    }
}
