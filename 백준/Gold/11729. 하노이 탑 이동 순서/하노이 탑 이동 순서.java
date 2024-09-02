import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	hanoi(N,1,2,3);
    	System.out.println(cnt);
    	System.out.print(sb);
    	sc.close();
    } // end of main
    
    static void move(int start, int end) {
    	sb.append(start+" "+end+"\n");
    	return;
    } // end of move
    static void hanoi(int n, int start, int via, int end) {
    	if(n == 1) {
    		move(start,end);
    		cnt++;
    		return;
    	}
    	
    	hanoi(n-1,start,end,via);
    	move(start,end);
    	cnt++;
    	hanoi(n-1,via,start,end);
    } // end of hanoi
} // end of class
