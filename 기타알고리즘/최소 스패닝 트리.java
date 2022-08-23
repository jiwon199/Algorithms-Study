import java.util.*;
import java.io.*;

public class Main {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		//sort했을때 가중치 오름차순 되도록..
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}

	 
	static int [] parents;
	static int V,E;
	static Edge[] edgeList;
	
	static void make() { //크기가 1인 서로소 집합 생성(모든 정점들이 서로 연결되지 않은 상태)
		parents=new int[V];
		for(int i=0;i<V;i++) //모든 노드가 자신을 부모로 하는 상황
			parents[i]=i;
	}
	static int find(int a) { //a의 대표자 찾기
		if(parents[a]==a) return a; 
		return parents[a]=find(parents[a]); //대표자를 나의 부모로..path compression
		
	}
	static boolean union(int a,int b) { //true 리턴하면 union 성공
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot==bRoot) return false;
		
		//부모가 다르면 왼쪽의 집합에 오른쪽의 집합 흡수시킴
		parents[bRoot]=aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int TC = Integer.parseInt(br.readLine());

		//for (int tc = 1; tc <= TC; tc++) {
			String[] info = br.readLine().split(" ");
			V= Integer.parseInt(info[0]); //정점
			E = Integer.parseInt(info[1]); //간선
			parents=new int[V];
			edgeList=new Edge[E];
			 
			for(int i=0;i<E;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				edgeList[i]=new Edge(Integer.parseInt(st.nextToken())-1,
						Integer.parseInt(st.nextToken())-1,
						Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(edgeList);
			make();
			int result=0;
			int count=0;
			for(Edge edge:edgeList) {
				//성공했다면 분리되어 있던 무리가 합쳐진것
				if(union(edge.from,edge.to)) {
					result+=edge.weight; //가중치비용도 누적
					if(++count==V-1) break;
				}
				
			}
			System.out.println(result);
			//System.out.println("#"+tc+" "+result);
		}
	//}

	 

}
