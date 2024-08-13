import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_1860_진기의최고급붕어빵_D3_조강민_170ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc<=T;tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList<>();
			String[] customer = br.readLine().split(" ");
			for(int i = 0 ; i<N;i++) {
				list.add(Integer.parseInt(customer[i]));
			}
			Collections.sort(list);
			
			boolean flag = true;
			for(int i =0;i<list.size();i++) {
				if(((list.get(i)/M)*K - i) <=0) {
					flag = false;
					break;
				} 
			}
			
			if(flag) {
				sb.append("#"+tc+" Possible");
			} else {
				sb.append("#"+tc+" Impossible");
			}
			sb.append("\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
