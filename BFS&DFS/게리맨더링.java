import java.util.*;
import java.io.*;

public class Main {
	public static int [] output; //뽑힌 애들
	 
	public static int [] people; 
	public static List <Integer> [] info;
	public static int [] color; 
	static int n,r,ans;
	static Queue <Integer> q;
	static boolean [] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		n=Integer.parseInt(br.readLine()); 
		people=new int[n];
		info=new List[n];
		ans=Integer.MAX_VALUE;
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			people[i]=Integer.parseInt(st.nextToken());
			info[i]=new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			 
			int m=Integer.parseInt(st.nextToken());
			for(int j=0;j<m;j++) {
				int num=Integer.parseInt(st.nextToken())-1;
				info[i].add(num);
				info[num].add(i);
			}
			
		}
		
		
		for(int i=1;i<=n/2;i++) {
			r=i;
			output=new int[r];
			Arrays.fill(output, -1);
			combi(0,0);
		}
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	 
		 
		 
		 
	}
	public static void combi(int start,int cnt) {
		if(cnt==r) {
			color=new int[n];
			int []colorInfo=setColor();
			
			if(isConnected(colorInfo[0])&&isConnected(colorInfo[1])) {
				 int gap=getGap();
				 ans=Math.min(gap, ans);
			}
			 
			return;
		}
		for(int i=start;i<n;i++) {
			output[cnt]=i;
			combi(i+1,cnt+1);
		}
	}
	private static int getGap() {
		int cnt1=0;
		int cnt2=0;
		for(int i=0;i<n;i++) {
			if(color[i]==1) cnt1+=people[i];
			else cnt2+=people[i];
		}
		return Math.abs(cnt1-cnt2);
	}
	private static boolean isConnected(int node) {
		q=new LinkedList<>();
		visited=new boolean[n];
		visited[node]=true;
		q.add(node);
		int col=color[node];
		while(!q.isEmpty()) {
			int now=q.poll();
			for(int next:info[now]) {
				if(color[next]==col&&!visited[next]) {
					visited[next]=true;
					q.add(next);
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(color[i]==col) {
				if(!visited[i]) return false;
			}
		}
		
		return true;
	}
	 
	public static int [] setColor() {
		int red=-1;
		int blue=-1;
		for(int i=0;i<n;i++) {
			 if(contain(i)) {
				 color[i]=1;
				 red=i;
			 }
			 else blue=i;
		}
		return new int [] {red,blue};
	}
	public static boolean contain(int i) {
		for(int num:output) {
			if(num==i) return true;
		}
		return false;
	}
	
	public static boolean check() {
		if(r>=3) {
			if(output[0]==0&&output[1]==2&&output[2]==3) {
				return true;
			}
		}
		return false;
	}
}
