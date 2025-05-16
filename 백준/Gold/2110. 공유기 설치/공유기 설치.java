import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for(int i = 0 ;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long max = 0;

        long left = 1;
        long right = arr[N-1] - arr[0];

        while(left<=right){
            long mid = (left+right)/2;
            int cnt = 1;
            long num = arr[0];
            for(int i = 1 ; i<N ;i++){
                if((arr[i]-num)>=mid){
                    num = arr[i];
                    cnt++;
                }
            }

            if(cnt>=C){
                max = mid;
                left = mid+1;
            } else{
                right = mid-1;
            }
        }
        System.out.println(max);
    } // end of main
} // end of class\

