package backjoon;

import java.util.*;
import java.io.*;

 
public class Main {
		 
		public static void main(String [] args) throws Exception{
			 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			 int [][] graph=new int[100][100];
			 int n=Integer.parseInt(br.readLine());
			 for(int t=0;t<n;t++) {
				 String [] temp=br.readLine().split(" ");
				 int x=Integer.parseInt(temp[0]);
				 int y=Integer.parseInt(temp[1]);
				 for(int i=x;i<x+10;i++) {
					 for(int j=y;j<y+10;j++) {
						 graph[j][i]=1;
						 //System.out.println("ddd");
					 }
				 }
				  
			 }
			 	 
			 int sum=0;
			 for(int i=0;i<100;i++) {
				 for(int j=0;j<100;j++) {
					 sum+=graph[i][j];
				 }
			 }
			 System.out.println(sum);
		}
		 

}
