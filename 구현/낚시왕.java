import java.util.*;
import java.io.*;

public class Main {

	public static class Shark{
		 
		int x;
		int y;
		int size;
		int direction;
		int speed;
		int state; //1이면 살아있는 상태
		
		public Shark(int speed, int direction, int size,int x,int y,int state) {
			super();
			this.size = size;
			this.direction = direction;
			this.speed = speed;
			this.x=x;
			this.y=y;
			this.state=state;
		}
		
	}
	 
	static int [][] graph; //상어들의 번호로 위치를 표현
	static Shark [] sharkInfo; //인덱스=상어번호. 상어들의 정보 저장
	static int [] dx= {-1,1,0,0};
	static int [] dy= {0,0,1,-1};
	static int R,C,M,humanPos,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		graph=new int[R][C];
		sharkInfo=new Shark[M+1];
		humanPos=0;
		ans=0;
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			graph[r-1][c-1]=i+1;
			sharkInfo[i+1]=new Shark(s,d-1,z,r-1,c-1,1);
		}
		
		while(true) {
			if(humanPos==C) break;
			 
			catchFish();
			moveAll();
		 
			humanPos++;
		}
		System.out.println(ans);
		
		
	}
	private static void catchFish() {
		 int num=getFishNum();
		 if(num!=0) {
			 ans+=sharkInfo[num].size;
			 sharkInfo[num].state=0;
		 }
		
	}
	public static int getFishNum() {
		for(int i=0;i<R;i++) {
			if(graph[i][humanPos]!=0) {
				int res=graph[i][humanPos];
				graph[i][humanPos]=0;
				return res;
			}
		}
		return 0;
	}
	private static void moveAll() {
		 //sharkInfo에서 먼저 x,y값 조정
		//그래프 0으로 초기화하고
		//sharkInfo의 x,y값에 맞게 그래프에 상어번호 입력
		for(int i=1;i<=M;i++) {
			if(sharkInfo[i].state==1) {
				for(int j=0;j<sharkInfo[i].speed;j++) {
					moveShark(sharkInfo[i]);
				}
			}	 
		}
		clearGraph();
		for(int i=1;i<=M;i++) {
			if(sharkInfo[i].state==1) {
				 int x=sharkInfo[i].x;
				 int y=sharkInfo[i].y;
				 if(graph[x][y]==0) graph[x][y]=i;
				 else {
					  
					 if(sharkInfo[graph[x][y]].size<sharkInfo[i].size) {
						 sharkInfo[graph[x][y]].state=0;
						 graph[x][y]=i;
						 
					 }
					 else {
						 sharkInfo[i].state=0;
					 }
				 }
			}	 
		}
		
		
	}
	//방향에 맞게 한 칸 이동
	public static void moveShark(Shark shark) {
		int x=shark.x;
		int y=shark.y;
		int d=shark.direction;
		
		int nx=x+dx[d];
		int ny=y+dy[d];
		if(nx>=0&&nx<R&&ny>=0&&ny<C) {
			shark.x=nx;
			shark.y=ny;
		}
		else {
			d=getReverseDirection(d);
			nx=x+dx[d];
			ny=y+dy[d];
			shark.x=nx;
			shark.y=ny;
			shark.direction=d;
		}
	}
	public static int getReverseDirection(int d) {
		if(d==0) return 1;
		else if(d==1) return 0;
		else if(d==2) return 3;
		else return 2;
	}
	public static void clearGraph() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				graph[i][j]=0;
			}
		}
	}
	
	public static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	 
}
