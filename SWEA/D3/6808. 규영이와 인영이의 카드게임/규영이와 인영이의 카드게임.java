import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] gyuCard;
	static int[] inCard;
	static boolean[] visited;
	static int[] permutation ;
	static int win ;
	static int lose ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ;tc<=T ;tc++) {
			gyuCard = new int[9];
			inCard = new int[9];
			boolean[] cardUsed = new boolean[19];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i= 0 ; i<9 ; i++) {
				gyuCard[i] = Integer.parseInt(st.nextToken());
				cardUsed[gyuCard[i]] = true;
			}
			int idx = 0;
			for(int i =1 ;i<=18;i++) {
				if(!cardUsed[i]) {
					inCard[idx++] = i;
				}
			}
			win = 0;
			lose = 0;
			visited = new boolean[9];
			permutation = new int[9];
			perm(0);
			
			sb.append("#"+tc+" "+win+" "+lose+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void perm(int r) {
		if(r == 9) {
			int gScore = 0;
			int iScore = 0;
			for(int i = 0 ; i<9;i++) {
				if(gyuCard[i]>permutation[i]) {
					gScore+=gyuCard[i]+permutation[i];
				} else if( gyuCard[i]<permutation[i]) {
					iScore+=gyuCard[i]+permutation[i];
				}
			}
			
			
			if(gScore>iScore) {
				win++;
			} else if (gScore<iScore) {
				lose++;
			}
			return;
		}
		
		for(int i = 0 ;i<9;i++) {
			if(!visited[i]) {
				visited[i] = true;
				permutation[r] = inCard[i];
				perm(r+1);
				visited[i] = false;
			}
		}
	} // end of perm
} // end of class
