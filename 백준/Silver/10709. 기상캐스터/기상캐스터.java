import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i<R;i++) {
			String s = br.readLine();
			boolean flag = false;
			int num = 0;
			for(int j = 0 ; j<C;j++) {
				char wther = s.charAt(j);
				if(wther == 'c') {
					num = 0;
					flag = true;
					sb.append(num+" ");
				} else{
					if(!flag) {
						sb.append(-1+" ");
					} else {
						sb.append(++num+" ");
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	} // end of main
} // end of class
