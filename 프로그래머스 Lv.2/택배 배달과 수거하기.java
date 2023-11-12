import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans=0;
        //밖에다 놓고 누적으로 계산해야 한번에 많이 배달/수거
        int delivery=0;
        int pickup=0;
        for(int i=n-1;i>=0;i--){
              
            if(deliveries[i]>0||pickups[i]>0){ 
                int cnt=0;
                while(deliveries[i]>delivery||pickups[i]>pickup){
                    cnt++;
                    delivery+=cap;
                    pickup+=cap;
                }
                
            delivery-=deliveries[i];
            pickup-=pickups[i];
            ans+=cnt*(i+1)*2;
             
             }
        }
        return ans;
         
    }

        
}
