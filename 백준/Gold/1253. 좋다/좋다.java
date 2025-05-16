import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for(int i = 0 ; i<N ;i++){
            if(binarySearch(i)) cnt++;

        }

        System.out.println(cnt);
    }

    static boolean binarySearch(int idx){
        int left = 0;
        int right = N-1;
        long target = arr[idx];
        long sum = 0;
        while(left<right){
            sum = arr[left]+arr[right];
            if(idx == left){
                left++;
                continue;
            } else if (idx==right) {
                right--;
                continue;
            }
            if(sum == target) return true;
            if(sum<target){
                left++;
            } else {
                right--;
            }

        }
        return false;
    }
}
