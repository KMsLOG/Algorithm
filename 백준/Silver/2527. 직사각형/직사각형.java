import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc =0 ; tc<4;tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(x1>p2 || y1>q2 || p1<x2 || q1<y2) {
				sb.append("d \n");
			} else if((x1==p2 && y1==q2) ||(x1==p2 && q1 ==y2)||(p1==x2 && q1 == y2)||(p1==x2 && y1==q2)) {
				sb.append("c \n");
			} else if(p1==x2 || q1 == y2 || p2 == x1 || q2==y1) {
				sb.append("b \n");
			} else {
				sb.append("a \n");
			}
		}
		
		System.out.print(sb);
	} // end of main
} // end of class
