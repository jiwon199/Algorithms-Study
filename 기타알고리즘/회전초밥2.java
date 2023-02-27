import java.util.*;
import java.io.*;
public class baekjoon {

	static int n,d,k,c; //접시 수, 초밥 종류, 연속 접시 수, 쿠폰 번호
	static Set <Integer> set=new HashSet<>();
	static int [] dish;
	static int [] dishNum;
	static int cnt,ans;
	public static void main(String[] args) throws Exception{
		  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		  String [] input=br.readLine().split(" ");
		  n=Integer.parseInt(input[0]);
		  d=Integer.parseInt(input[1]);
		  k=Integer.parseInt(input[2]);
		  c=Integer.parseInt(input[3]);
		  ans=0;
		   
		  dish=new int[n*2];
		  dishNum=new int[d+1];
		  for(int i=0;i<n;i++) {
			  dish[i]=Integer.parseInt(br.readLine());
			  dish[i+n]=dish[i];
		  }
		  
		  //쿠폰은 받는다고 가정
		  dishNum[c]=1;
		  cnt=1;
		  //0~k-1번까지 dishNum에 체크 0,1,2,3
		  for(int i=0;i<k;i++) {
			  updatePlusCnt(dish[i]);
			   
		  }
		  ans=Math.max(cnt, ans);
		 
		  for(int i=k;i<n+k+1;i++) {
			  //i-k번을 dishNum에서 빼고, i번을 추가
			  updateMinusCnt(dish[i-k]);
			  updatePlusCnt(dish[i]);
			  ans=Math.max(cnt, ans);
			  
			   
		  }
		  System.out.println(ans);
		  
	}
	//dishNum num를 추가했을때 cnt 업데이트 
	public static void updatePlusCnt(int num) {
		if(dishNum[num]==0) cnt++;
		dishNum[num]+=1;
	}
	//num 뺐을때 cnt 업데이트
	public static void updateMinusCnt(int num) {
		dishNum[num]-=1;
		if(dishNum[num]==0) cnt--;
	}

}
