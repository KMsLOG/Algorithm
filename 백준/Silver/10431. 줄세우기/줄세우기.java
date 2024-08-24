import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc<T;tc++) {
			int[] arr = new int[20];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int TC = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i<20;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			
			for(int i = 1 ; i<20;i++) {
				int idx = i;
				while(idx>0) {
					if(arr[idx-1]>arr[idx]) {
						int temp = arr[idx];
						arr[idx] = arr[idx-1];
						arr[idx-1] = temp;
						cnt++;
						idx--;
					} else {
						break;
					}
				}
			}
			
			sb.append(TC+" "+cnt+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
