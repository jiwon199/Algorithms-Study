import java.util.*;
class Solution {
    Map <String,List<String>> map=new HashMap<>();
    Map <String,Integer> answerMap=new HashMap<>();
    int defaultTime,defaultFee,unitMin,unitFee;
    public int[] solution(int[] fees, String[] records) {
         
        defaultTime=fees[0];
        defaultFee=fees[1];
        unitMin=fees[2];
        unitFee=fees[3];
        
        List <String> carNums=new ArrayList<>();
        for(String record:records){
            String [] info=record.split(" ");
            List <String> now=map.getOrDefault(info[1],new ArrayList<>());
            now.add(info[0]);
            map.put(info[1],now);
             
        }
        
        int size=0;
        for(String key:map.keySet()){
            int time=getTotalTime(map.get(key));
            int fee=getFee(time);
            answerMap.put(key,fee);
             
            size++;
            carNums.add(key);
        }
        
        int[] answer = new int[size];
        Collections.sort(carNums);
        int idx=0;
        for(String carNum:carNums){
            answer[idx++]=answerMap.get(carNum);
        }
        
        return answer;
    }
    //차량 ㅁㅁㅁㅁ가 몇 분 썼는지 계산
    public int getTotalTime(List <String> record){
        int time=0;
        //레코드가 홀수면 23:59를 추가.
        if(record.size()%2==1){
            record.add("23:59");
        }
        for(int i=0;i<record.size();i+=2){
            time+=getTime(record.get(i),record.get(i+1));
        }
        
        return time;
    }
    //입차-출차 시간이 주어졌을때 몇 분 썼는지 계산하여 반환
    public int getTime(String in,String out){
        int outH= Integer.parseInt(out.substring(0,2));
        int outM=Integer.parseInt(out.substring(3));
        int inH=Integer.parseInt(in.substring(0,2));
        int inM=Integer.parseInt(in.substring(3));
        
        int hour=outH-inH;
        int min=outM-inM;
         
        return hour*60+min;
    }
    //사용 시간에 대한 요금을 계산
    public int getFee(int time){
        if(time<=defaultTime) return defaultFee;
        else{
            int useTime=time-defaultTime;
            int unit=(int)Math.ceil((double)useTime/unitMin) ; 
            return unit*unitFee+defaultFee;
        }
    }
    
}
