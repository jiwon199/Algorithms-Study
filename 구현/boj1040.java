import java.util.*;
import java.io.*;
public class Main {

	public static int n,m;
	public static int [] person; //1이면 진실을 듣는 사람.
	static int [] people;
	public static List <int []> party=new ArrayList<>();
	public static List <Integer> list [];
	public static void main(String[] args) throws Exception{
		//System.out.println("Dddd");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		person=new int[n+1];
		list=new ArrayList[n+1];
		Queue <Integer> q=new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<Integer>(); //list[i]는 i번 인간과 같이 파티를 즐긴 사람들의 목록
		}
		
		 
		st=new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) {
			int per=Integer.parseInt(st.nextToken());
			person[per]=1;
			q.add(per);
		}
		
		 
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken());
			people=new int[p];
			for(int j=0;j<p;j++) {
				people[j]=Integer.parseInt(st.nextToken()); //해당 파티에 참가한 사람들
			}
			updateList(p);
			party.add(people);
		}
		 
		while(!q.isEmpty()) {
			int now=q.poll();
			for(int next:list[now]) {
				if(person[next]==0) {
					person[next]=1;
					q.add(next);
				}
			}
		}
	 
		int count=0;
		for(int [] p:party) {
			//참가한 인간들이 전부 진실을 모르면 카운트
			int l=p.length;
			people=new int[l];
			
			for(int i=0;i<l;i++) people[i]=p[i];
		 
			if(!isReal())  
				count++;
		 
		}
		System.out.println(count);
		 
		 
	}
	public static void updateList(int p) {
		for(int i=0;i<p;i++) {
			for(int j=0;j<p;j++) {
				if(people[i]!=people[j]) {
					list[people[i]].add(people[j]);
					list[people[j]].add(people[i]);
				}
			}
		}
	}
	public static boolean isReal() {
		for(int p:people) {
			if(person[p]==1) return true;
		}
		return false;
	}
	 
	 
}
 
