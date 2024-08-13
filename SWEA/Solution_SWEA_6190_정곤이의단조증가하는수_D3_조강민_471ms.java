import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6190_정곤이의단조증가하는수_D3_조강민_471ms {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int maxnum = 0;
			for(int i = 0 ; i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0 ; i<arr.length-1;i++) {
				for(int j = i+1 ;j<arr.length;j++) {
					int num = arr[i]*arr[j];
					int prev = 9;
					int copynum = num;
					boolean flag = true;
					while(copynum > 0) {
						int nextnum = copynum/10;
						int remain = copynum%10;
						if(prev < remain) {
							flag = false;
							break;
						}
						copynum = nextnum;
						prev= remain;
					}
					if(flag && maxnum<num) {
						maxnum = num;
					}
				}
			}
			
			if(maxnum == 0) {
				sb.append("#"+tc+" "+(-1));
			} else {
				sb.append("#"+tc+" "+maxnum);
			}
            sb.append("\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
