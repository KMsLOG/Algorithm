import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cham = Integer.parseInt(br.readLine());
		
		int max_h = 0;
		int maxH_idx = 0;
		int max_w = 0;
		int maxW_idx = 0;
		
		int[] way = new int[6];
		int[] dist = new int[6];
		
		for(int i = 0 ; i<6;i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			way[i] = Integer.parseInt(st.nextToken());
			dist[i] = Integer.parseInt(st.nextToken());
			if(way[i]==1 || way[i]==2) {
				if(max_h<dist[i]) {
					max_h = dist[i];
					maxH_idx = i;
				}	
			} else {
				if(max_w < dist[i]) {
					max_w = dist[i];
					maxW_idx = i;
				}
			}
		}
		
		int square = max_w * max_h -(dist[(maxW_idx + 3) % 6] * dist[(maxH_idx + 3) % 6]);
		System.out.println(square*cham);
		
	} // end of main
} // end of class
