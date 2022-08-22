package backjoon;

import java.util.*;
import java.io.*;

public class Main {
	static int l, c;
	static char [] output;
	static char [] alpha;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		l = Integer.parseInt(info[0]);
		c = Integer.parseInt(info[1]);
		output=new char[l];
		alpha=new char[c];
		String [] info2=br.readLine().split(" ");
		for(int i=0;i<c;i++) {
			alpha[i]=info2[i].charAt(0);
		}
		Arrays.sort(alpha);
		dfs(0,0);
	    
	}
	public static void dfs(int cnt,int start) {
		if(cnt==l) {
			if(isAble()) {
				for(int i=0;i<l;i++) {
					System.out.print(output[i]);
				}
				System.out.println();
			}
			 
			return;
		}
		for(int i=start;i<c;i++) {
			output[cnt]=alpha[i];
			dfs(cnt+1,i+1);
			
		}
	}
	public static boolean isAble() {
		int a=0;
		int b=0;
		for(int i=0;i<l;i++) {
			if(output[i]=='a'||output[i]=='e'||output[i]=='i'||output[i]=='o'||output[i]=='u') a++;
			else b++;
		}
		if(a>=1&&b>=2) return true;
		else return false;
	}

}
