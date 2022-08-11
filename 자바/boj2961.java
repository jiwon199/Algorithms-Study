package backjoon;
import java.util.*;
import java.io.*;
public class Main {
	public static int [] output;
	public static boolean [] visited;
	public static int [] index; //1~n까지의 인덱스
	public static int [][] info;
	public static int answer=Integer.MAX_VALUE;
	public static int n;
	public static void main(String [] args) throws Exception{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 n=Integer.parseInt(br.readLine());
		 index=new int [n];
		 info=new int [n][2];
		 for(int i=0;i<n;i++) {
			 index[i]=i;
			 String [] temp=br.readLine().split(" ");
			 info[i][0]=Integer.parseInt(temp[0]); //신맛
			 info[i][1]=Integer.parseInt(temp[1]); //쓴맛		 
		 }
		 for(int i=1;i<=n;i++) {
			 output=new int[i];
			 combi(0,0,i);
		 }
		 System.out.println(answer);
		 
	}
	
	public static void combi(int cnt,int start,int r) {
		if(cnt==r) {
			answer=Math.min(answer, getGap(r));
			return;
		}
		for(int i=start;i<n;i++) {
			output[cnt]=index[i];
			combi(cnt+1,i+1,r);
		}
	}
	public static int getGap(int r) {
		//ouput에 있는 인덱스들로 요리했을때 차이가 얼마인지 리턴
		int mul=1;
		int sum=0;
		for(int i=0;i<r;i++) {
			mul*=info[output[i]][0];
			sum+=info[output[i]][1];
		}
		return Math.abs(mul-sum);
	}
  
}
