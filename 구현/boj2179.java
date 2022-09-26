import java.util.*;
import java.io.*;

public class Main {
 
	static Map <String,List> map=new HashMap<>();
	static List <String> list=new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String word=br.readLine();
			for(int j=0;j<=word.length();j++) {
				String sub=word.substring(0,j);
				put(sub,word);
				
			}
			list.add(word);
		}
		
	  
		int max=0;
		//일단 value가 2 이상인 애들중 가장 긴 접두사의 길이 알아내기.
		for(String key:map.keySet()) {
			if(map.get(key).size()>=2) {
				max=Math.max(max, key.length());
			}
			 
		}
		 
		 
		//겹치는 접두사 없으면 가장 먼저 나온 단어2개가 답.
		if(max==0) {
			System.out.println(list.get(0));
			System.out.println(list.get(1));
		}
		//여러개면
		else {
			String ans1="";
			String ans2="";
			 
			//입력 순서대로 단어를 보는데
			for(String word:list) {
				//그 단어길이가 최대길이접두사보다 길면
				if(word.length()>=max) {
					//그 접두사만큼 쪼개서
					String key=word.substring(0,max);
					//거기 해당하는 단어가 몇개 있는지 보고 그 단어가 당첨이면
					if(map.get(key).size()>=2) {
						ans1=(String) map.get(key).get(0);
						ans2=(String) map.get(key).get(1);
						 
						break;
					}
				}
				 
			 
			}
			System.out.println(ans1);
			System.out.println(ans2);
			
			 
		}
		 
	}
	public static void put(String key,String word) {
		if(map.getOrDefault(key, null)==null) {
			List <String> strs=new ArrayList<>();
			strs.add(word);
			map.put(key, strs);
		}
		else {
			List <String> strs=map.get(key);
			strs.add(word);
			map.put(key, strs);
		}
	}
}
