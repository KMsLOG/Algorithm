import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);;
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<M;i++) {
			int key = Integer.parseInt(st.nextToken());
			int yes = Collections.binarySearch(list, key);
			if(yes>=0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
