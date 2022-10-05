import java.util.*;
import java.io.*;

public class Main {

	static char[][] graph;
	static int n, m,sx,sy;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = {0,0, -1, 1 };
	static Map <String,Integer> visited=new HashMap<>(); //좌표+인벤토리, 1이면 방문
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph=new char[n][m];
		int ans=-1;
		 
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<m;j++) {
				graph[i][j]=line.charAt(j);
				if(graph[i][j]=='0') {
					sx=i;
					sy=j;
				}
			}
		}
		
		
		Queue <String []> q=new LinkedList<>();
		q.add(new String [] {String.valueOf(sx),String.valueOf(sy),"000000","0"});
		 
		visited.put(sx+" "+sy+" "+"000000", 1);
		
		
		while(!q.isEmpty()) {
			String [] info=q.poll();
			int x=Integer.parseInt(info[0]);
			int y=Integer.parseInt(info[1]);
			int cnt=Integer.parseInt(info[3]);
			 //System.out.println(x+" "+y+" "+info[2]);
			if(graph[x][y]=='1') {
				ans=cnt;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0&&ny>=0&&nx<n&&ny<m) {
					 
					if(graph[nx][ny]!='#'&&!isVisited(nx,ny,info[2])) {
						 if(graph[nx][ny]=='.'||graph[nx][ny]=='1'||graph[nx][ny]=='0') {
							 setVisited(nx,ny,info[2]);
							 q.add(new String [] {String.valueOf(nx),String.valueOf(ny),info[2],String.valueOf(cnt+1)});
							  
						 }
						 else if(graph[nx][ny]>='a'&&graph[nx][ny]<='f') {
							 
							 String inventory= getInventory(info[2],graph[nx][ny]);
							 //graph[nx][ny]='.';
							 setVisited(nx,ny,inventory);
							 q.add(new String [] {String.valueOf(nx),String.valueOf(ny),inventory,String.valueOf(cnt+1)});
						 }
						 else {
							  if(hasKey(graph[nx][ny],info[2])) {
								  setVisited(nx,ny,info[2]);
								  q.add(new String [] {String.valueOf(nx),String.valueOf(ny),info[2],String.valueOf(cnt+1)});
							  }
						 }
						  
					}
				}
			}
		}
		System.out.println(ans);
		
	}
	//문에 맞는 키가 있으면 true 리턴
	private static boolean hasKey(char door, String inventory) {
		int index=getIndex(door);
		if(inventory.charAt(index)!='0') return true;
		else return false;
	}

	public static boolean isVisited(int x,int y,String inventory) {
		String key=String.valueOf(x)+" "+String.valueOf(y)+" "+inventory;
		if(visited.getOrDefault(key, 0)==1) return true;
		else return false;
	}

	public static void setVisited(int x,int y,String inventory) {
		 String key=String.valueOf(x)+" "+String.valueOf(y)+" "+inventory;
		 visited.put(key, 1);
	}
	//새로 얻은 열쇠를 인벤토리에 반영해서 반환
	public static String getInventory(String lastInventory,char key) {
		int index=getIndex(key);
		if(lastInventory.charAt(index)=='0') {
			 
			char [] tmp=lastInventory.toCharArray();
			tmp[index]='1';
			String newInventory="";
			for(int i=0;i<6;i++) newInventory+=tmp[i];
			return newInventory;
		}
		else return lastInventory;
	}
	public static int getIndex(char alpha) {
		if(alpha=='a'||alpha=='A') return 0;
		else if(alpha=='b'||alpha=='B') return 1;
		else if(alpha=='c'||alpha=='C') return 2;
		else if(alpha=='d'||alpha=='D') return 3;
		else if(alpha=='e'||alpha=='E') return 4;
		else return 5;
	}
	public static void clearVisited() {
		for(String key:visited.keySet()) {
			visited.put(key, 0);
		}
	}
	 

}
