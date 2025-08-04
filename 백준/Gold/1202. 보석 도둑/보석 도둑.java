import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jew implements Comparable<Jew>{
    int cost;
    int val;

    public Jew(int cost, int val){
        this.cost = cost;
        this.val = val;
    }

    @Override
    public int compareTo(Jew o) {
        return cost - o.cost;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jew[] jews = new Jew[N];
        for(int i = 0 ; i<N;i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jews[i] = new Jew(c,v);
        }

        int[] bag = new int[K];
        for(int i = 0 ; i<K;i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Arrays.sort(jews);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int jewIdx = 0;

        for(int i = 0; i < K; i++) {
            while (jewIdx < N && jews[jewIdx].cost <= bag[i]) {
                pq.add(jews[jewIdx].val);
                jewIdx++;
            }
            if (!pq.isEmpty()) {
                int cur = pq.poll();
                result += cur;
            }
        }

        System.out.println(result);
    } // end of main
} // end of class