import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int [] T= new int[n+1];
        int [] P= new int[n+1];
        int [] dp=new int[n+1];

        for(int i=0;i<n;i++){
            String [] input=br.readLine().split(" ");
            T[i]=Integer.parseInt(input[0]);
            P[i]=Integer.parseInt(input[1]);
        }

        for(int i=0;i<n;i++){
            int next=i+T[i];

            if(next<=n){
                dp[next]=Math.max(dp[next],dp[i]+P[i]);
            }
            dp[i+1]=Math.max(dp[i+1],dp[i]);

        }

        System.out.print(dp[n]);

    }

}
