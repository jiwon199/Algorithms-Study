package backjoon;
import java.util.*;
import java.io.*;
public class Main {
	public static int [] output;
	public static boolean [] visited;
	public static int [] numbers;
	public static int [] info;
	public static void main(String [] args) throws Exception{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 numbers=new int[9];
		 output=new int[2];
		 info=new int[9];
		 for(int i=0;i<9;i++) {
			numbers[i]=i;
		 }
		 for(int i=0;i<9;i++) {
			 info[i]=Integer.parseInt(br.readLine());
		 }
		  
		 combi(0,0);
	}
	
	public static void combi(int count,int start) {
		 if(count==2) {
			 //System.out.println(Arrays.toString(output));
			 if(check(output[0],output[1])) {
				 for(int i=0;i<9;i++) {
					 if(i==output[0]||i==output[1]) continue;
					 System.out.println(info[i]);
				 }
			 }
			 return;
		 }
		 for(int i=start;i<9;i++) {
			 output[count]=numbers[i];
			 combi(count+1,i+1);
			 
		 }
	}
	public static boolean check(int a,int b) {
		int sum=0;
		for(int i=0;i<9;i++) {
			if(i==a||i==b) continue;
			sum+=info[i];
		}
		if(sum==100) return true;
		else return false;
	}
	
	 
	 
}
