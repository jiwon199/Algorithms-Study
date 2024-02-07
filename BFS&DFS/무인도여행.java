import java.util.*;

    class Solution {

        public static ArrayList <Integer> array=new ArrayList<>();
        public static int [][] graph;
        public static boolean [][] visited;
        public static int n,m;
        public static int [] dx={-1,1,0,0};
        public static int [] dy={0,0,-1,1};
        public static Queue<int[]> queue = new LinkedList<>();

        public int[] solution(String[] maps) {

            n=maps.length;
            m=maps[0].length();
            graph=new int[n][m];
            visited=new boolean[n][m];


            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    char c=maps[i].charAt(j);
                    if(c=='X'){
                        graph[i][j]=-1;
                    }
                    else graph[i][j]=c-'0';
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(!visited[i][j]&&graph[i][j]!=-1){
                        queue.add(new int []{i,j});
                        visited[i][j]=true;
                        bfs();
                    }
                }
            }

            Collections.sort(array);
            int[] answer = new int[array.size()];
            for(int i=0;i<array.size();i++){
                answer[i]=array.get(i);
            }
            if(array.size()==0) return new int [] {-1};
            return answer;
        }
        public static void bfs(){
            int sum=0;
            while(!queue.isEmpty()){
                int [] now=queue.poll();
                sum+=graph[now[0]][now[1]];
                
                for(int i=0;i<4;i++){
                    int nx=now[0]+dx[i];
                    int ny=now[1]+dy[i];

                    if(nx>=0&&ny>=0&&nx<n&&ny<m){
                        if(!visited[nx][ny]&&graph[nx][ny]!=-1){
                            queue.add(new int []{nx,ny});
                            visited[nx][ny]=true;
                        }
                    }
                }

            }
            array.add(sum);
            
        }
    }

