import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 최장 증가 수열의 길이를 계산하는 메소드
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] lis = new int[n];  // lis 배열은 부분 수열의 마지막 원소들을 저장합니다
        int length = 0;  // lis 배열의 현재 길이
        
        for (int num : nums) {
            // 이진 탐색을 이용해 현재 num이 삽입될 위치를 찾습니다
            int left = 0, right = length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lis[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            // left는 num이 삽입될 위치입니다
            lis[left] = num;
            
            // lis 배열의 길이를 업데이트합니다
            if (left == length) {
                length++;
            }
        }
        
        return length;
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ;i<N;i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        int length = lengthOfLIS(nums);
        System.out.println(length);
    }
}
