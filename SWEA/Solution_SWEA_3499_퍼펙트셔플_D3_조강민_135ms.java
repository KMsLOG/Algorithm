import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_SWEA_3499_퍼펙트셔플_D3_조강민_135ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T ;tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] card = br.readLine().split(" ");
			List<String> first = new ArrayList<>();
			List<String> second = new ArrayList<>();
			Queue<String> queue = new LinkedList<>();
			if(card.length%2!=0) {
				for(int i = 0 ; i <= card.length/2;i++) {
					first.add(card[i]);
				}
				for(int i = card.length/2+1 ; i<card.length;i++) {
					second.add(card[i]);
				}
			} else {
				for(int i = 0 ; i < card.length/2;i++) {
					first.add(card[i]);
				}
				for(int i = card.length/2 ; i<card.length;i++) {
					second.add(card[i]);
				}
			}
			for(int i = 0 ; i<first.size();i++) {
				if(first.size()!=second.size()) {
					if(i == first.size()-1) {
						queue.offer(first.get(i));
					} else {
						queue.offer(first.get(i));
						queue.offer(second.get(i));
					}
				} else {
					queue.offer(first.get(i));
					queue.offer(second.get(i));
				}
			}
			
			sb.append("#"+tc+" ");
			for(String s : queue) {
				sb.append(s+" ");
			}
			sb.append("\n");
 		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
