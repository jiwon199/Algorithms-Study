import java.util.*;
import java.io.*;

 
public class Main {
		 
		public static void main(String [] args) throws Exception{
			 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			 PriorityQueue <int []> q=new PriorityQueue<>(new Comparator<int []>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (o1[0]==o2[0]) return o1[1]-o2[1];
					return o1[0]-o2[0];
				}
			 });
			 int n=Integer.parseInt(br.readLine());
			 for(int i=0;i<n;i++) {
				 int m=Integer.parseInt(br.readLine());
				 if(m==0) {
					 //큐에서 빼기
					 if(q.isEmpty()) System.out.println(0);
					 else System.out.println(q.poll()[1]);
				 }
				 else {
					 
					 q.add(new int [] {Math.abs(m),m});
				 }
			 }
			 
		}
		 

}
