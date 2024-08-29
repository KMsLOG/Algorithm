import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
 
class Hamburger {
    int score;
    int calorie;
 
    public Hamburger(int score, int calorie) {
        this.score = score;
        this.calorie = calorie;
    }
}
 
public class Solution {
 
    static Hamburger[] arr;
    static boolean[] visited;
    static int N, L;
    static int max;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
 
            arr = new Hamburger[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int calorie = Integer.parseInt(st.nextToken());
 
                arr[i] = new Hamburger(score, calorie);
            }
 
            max = Integer.MIN_VALUE;
            powerset(0,0,0);
 
            sb.append("#" + tc + " " + max + "\n");
        } // end of tc
        System.out.print(sb);
    } // end of main
    
    static void powerset(int idx, int score_sum, int calorie_sum) {
        if (idx == N) {
 
            if (L >= calorie_sum) {
                if (max < score_sum) {
                    max = score_sum;
                }
            }
            return;
        }
        
        if(calorie_sum>L) {
        	return;
        }
        
        
        calorie_sum += arr[idx].calorie;
    	score_sum += arr[idx].score;
        powerset(idx + 1, score_sum, calorie_sum);
        
        
        calorie_sum -= arr[idx].calorie;
    	score_sum -= arr[idx].score;
    	
    	
        powerset(idx + 1, score_sum, calorie_sum);
    } // end of powerset
 
} // end of class