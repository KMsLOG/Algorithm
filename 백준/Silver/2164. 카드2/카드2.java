import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1 ;i<=N;i++) {
			q.add(i);
		}
		
		while(q.size()!=1) {
			q.poll();
			int num  = q.poll();
			q.add(num);
		}
		
		System.out.println(q.poll());
	} // end of main
} // end of class
