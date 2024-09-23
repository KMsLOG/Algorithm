import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		TreeSet<Integer> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		
		List<Integer> list = new ArrayList<>(set);
		
		for(int i = 0 ;i<N;i++) {
			sb.append(Collections.binarySearch(list, arr[i])+" ");
		}
		System.out.println(sb);
	} // end of main
} // end of class
