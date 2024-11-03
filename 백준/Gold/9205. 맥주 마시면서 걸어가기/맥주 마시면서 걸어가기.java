import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int i;
		int j;
		
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			List<Node> Points = new ArrayList<>();
			ArrayList<Integer>[] arr = new ArrayList[N+2];
			
			
			for(int i = 0 ; i<N+2 ;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				Points.add(new Node(y,x));
				
				arr[i] = new ArrayList<>();
			}
			
			for(int i= 0 ; i<N+2 ;i++) {
				for(int j = i+1 ;j<N+2;j++) {
					if(Manhattan(Points.get(i), Points.get(j))<=1000) {
						arr[i].add(j);
						arr[j].add(i);
					}
				}
			}
			if(bfs(arr,N)) {
				sb.append("happy \n");
			} else {
				sb.append("sad \n");
			}
		} // end of tc
		
		System.out.print(sb);
	} // end of main
	
	static int Manhattan(Node n1, Node n2) {
		return(Math.abs(n1.i-n2.i)+Math.abs(n1.j-n2.j));
	} // end of Manhattan
	
	static boolean bfs(ArrayList<Integer>[] arr,int N) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+2];
		
		q.add(0);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : arr[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
				if(next == N+1) return true;
			}
		}
		return false;
	}
} // end of class
