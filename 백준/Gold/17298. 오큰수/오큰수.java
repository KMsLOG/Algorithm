import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i<N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < N ; i++){
            while(!stack.isEmpty() && arr[stack.peekLast()] < arr[i]){
                result[stack.pollLast()] = arr[i];
            }
            stack.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : result){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    } // end of main
} // end of class
