import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sqr implements Comparable<Sqr> {
	
	int x;
	int y;
	
	
	public Sqr(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	@Override
	public int compareTo(Sqr o) {
		return x - o.x;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		List<Sqr> wHouse = new ArrayList<Sqr>();
		int max_y = 0;
		int max_idx = 0;
		for(int i = 0 ; i<T;i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			wHouse.add(new Sqr(x,y));
			if(max_y<y) {
				max_y = y;
			}
		}
		Collections.sort(wHouse);
		for(int i = 0 ; i<T;i++) {
			if(wHouse.get(i).y == max_y) {
				max_idx = i;
				break;
			}
		}
		int sum = 0;
		
		int left_y = 0;
		int left_x = 0;
		for(int i = 0 ;i<=max_idx;i++) {
			if(left_y<wHouse.get(i).y) {
				sum+=left_y*(wHouse.get(i).x - left_x-1) + wHouse.get(i).y;
				left_y = wHouse.get(i).y;
				left_x = wHouse.get(i).x;
			}
		}
		
		int right_y = 0;
		int right_x = T;
		for(int i = wHouse.size()-1 ;i>max_idx;i--) {
			if(right_y<wHouse.get(i).y) {
				sum+=right_y*(right_x  - wHouse.get(i).x);
				
				right_y = wHouse.get(i).y;
				right_x = wHouse.get(i).x;
			}
			if(i == max_idx+1 && right_y <= max_y) {
				sum+=right_y*(right_x - wHouse.get(max_idx).x);
			}
			
		}
		
		
		
		
		System.out.println(sum);
	} //  end of main
} // end of class
