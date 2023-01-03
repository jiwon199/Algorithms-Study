package backjoon;

import java.util.*;
import java.io.*;
 
 
public class Main {
	 
	static int n,l;
	static int [][] graph;
	static List <Integer> gapIdxList=new ArrayList<>();
	static boolean [] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		graph=new int[n][n];
		int ans=0;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			if(isValid(graph[i])) ans++;
			if(isValid(getColArr(i))) ans++;
		}
		
		System.out.println(ans);
		
		
	}
	public static boolean isValid(int [] road) {
		gapIdxList.clear();
		int before=road[0];
		for(int i=1;i<n;i++) {
			if(road[i]!=before) {
				gapIdxList.add(i);
				before=road[i];
			}
		}
		 
		return checkRoad(road);
	}
	public static boolean checkRoad(int [] road) {
		visited=new boolean[n];
		 
		for(int idx:gapIdxList) {
			 
			int index=-1;
			int dir=0;
			//높이 차이 2이상이면 경사로x
			if(Math.abs(road[idx]-road[idx-1])>=2) return false;
			
			//idx,idx-1을 비교해서 idx가 더 크면 idx-1에 경사로 설치, idx-1이 더 크면 idx에 경사로 설치
			if(road[idx]>road[idx-1]) {
				 index=idx-1;
				 dir=-1;
			}else {
				index=idx;
				dir=1;
			}
			//l자리 확보되면 visited 체크
			if(isWayAble(index,dir,road)) checkVisited(index,dir);
			else return false;
			
		}
		return true;
	}
	public static void checkVisited(int index, int dir) {
		for(int i=0;i<l;i++) {
			 visited[index]=true;
			 index=index+dir; 
		 }
	}
	//l자리의 경사로가 지어지지 않은 자리 확보 가능 여부 반환
	public static boolean isWayAble(int idx,int dir,int [] road) {
		 int index=idx;
		 for(int i=0;i<l;i++) {
			 if(index<0||index>=n)return false;
			 if(road[index]!=road[idx]||visited[index])
				 return false;
			 index=index+dir; 
		 }
		 return true;
	}
	public static int [] getColArr(int col) {
		int [] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=graph[i][col];
		}
		return arr;
		
	}
	 
	 
	 
}
