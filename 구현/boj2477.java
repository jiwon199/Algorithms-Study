package backjoon;

import java.util.*;
import java.io.*;

public class Main {
	 
	public static List<Integer> line=new ArrayList<>();
	public static List<Integer> notUsed=new ArrayList<>();
	public static void main(String[] args) throws Exception {
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int n=Integer.parseInt(br.readLine());
		 for(int i=0;i<6;i++) {
			 String [] temp=br.readLine().split(" ");
			 line.add(Integer.parseInt(temp[1]));
		 }
		 int idx1=getMaxIndex(0);
		 int idx2=getMaxIndex(1);
		 int bigBox=line.get(idx1)*line.get(idx2);
		 int smallBox=getSmallBox(idx1,idx2);
		 System.out.println(n*(bigBox-smallBox));
		 
	}
	public static int getMaxIndex (int oddOrEven) {
		int max=0;
		int idx=0;
		for(int i=0;i<6;i++) {
			if(i%2==oddOrEven) {	 
				if(line.get(i)>max) {
					max=line.get(i);
					idx=i;
				}
			}
		}
		return idx;
	}
	 
	public static int getSmallBox(int index1,int index2) {
		getNotUsedIndex(index1);
		getNotUsedIndex(index2);
		List<Integer> arr=new ArrayList<>();
		for(int i=0;i<6;i++) {
			if(i!=index1&&i!=index2&&notInArr(i)) {
				arr.add(i);
			}
		}
		return line.get(arr.get(0))*line.get(arr.get(1));
	}
	public static void getNotUsedIndex(int index) {
		int i1=index+1;
		if(i1==6) i1=0;
		int i2=index-1;
		if(i2==-1) index=5;
		notUsed.add(i1);
		notUsed.add(i2);
	}
	public static boolean notInArr(int idx) {
		for(int num:notUsed) {
			if(num==idx) return false;
		}
		return true;
	}
 
 
}
