import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ;i<N;i++) {
			arr1.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ;i<N;i++) {
			arr2.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr1);
		Collections.sort(arr2,Collections.reverseOrder());
		
		int sum = 0;
		
		for(int i = 0; i<N;i++) {
			sum+= arr1.get(i)*arr2.get(i);
		}
		
		System.out.println(sum);
	} // end of main
} // end of class
