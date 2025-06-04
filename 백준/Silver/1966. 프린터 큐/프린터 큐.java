import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<N;i++){
               q.add(new int[]{i,Integer.parseInt(st.nextToken())});
            }
            int cnt = 0;
            while(!q.isEmpty()){
                int[] cur = q.poll();
                boolean isMax = true;

                for(int i = 0; i<q.size();i++){
                    if(cur[1]<q.get(i)[1]){
                        q.add(cur);
                        for(int j = 0 ; j<i;j++){
                            q.add(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(!isMax) continue;
                cnt++;
                if(cur[0]==M){
                    break;
                }
            }
            System.out.println(cnt);
        }
    } // end of main
} // end of class
