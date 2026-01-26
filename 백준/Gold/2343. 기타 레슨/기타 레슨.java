import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];

        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;

        for(int i = 0; i < N; i++){
            int time = Integer.parseInt(st.nextToken());
            lectures[i] = time;
            left = Math.max(left, time);
            right += time;
        }

        int answer = right;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int sum = 0;
            int cnt = 1;
            boolean check = true;

            for(int l : lectures){
                if(sum + l > mid){
                    cnt++;
                    sum = l;
                } else {
                    sum += l;
                }

                if(cnt > M){
                    check = false;
                    break;
                }
            }

            if(check){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
