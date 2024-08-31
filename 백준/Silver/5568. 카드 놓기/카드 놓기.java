import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<Integer> set = new HashSet<>();
	static boolean[] visited;
	static int n;
	static int k;
	static int[] arr;
	static int[] perArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		visited = new boolean[n];
		for(int i = 0 ; i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		perArr = new int[k];
		
		perm(0);
		System.out.println(set.size());
	} // end of main
	
	static void perm(int depth) {
		if(depth == k) {
			String s = "";
			for(int i : perArr) {
				s += Integer.toString(i);
			}
			set.add(Integer.parseInt(s));
			return;
		}
		
		for(int i = 0 ; i<n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				perArr[depth] = arr[i];
				perm(depth+1);
				visited[i] = false;
			}

		}
	} // end of perm
} // end of class
