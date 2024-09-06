import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int sum = 0;
		int idx = 0;
		boolean flag = true;
		String num = "";
		
		while(idx<s.length()) {
			char c = s.charAt(idx);
			
			if(c == '-') {
				if(flag) {
					sum+=Integer.parseInt(num);
					num = "";
				} else {
					sum-=Integer.parseInt(num);
					num = "";
				}
				flag =false;
				idx++;
				
			} else if(c == '+') {
				if(flag) {
					sum+=Integer.parseInt(num);
					num = "";
				} else {
					sum-=Integer.parseInt(num);
					num = "";
				}
				idx++;
			} else {
				num+=c;
				idx++;
			}
		} // end of while
		
		if(flag) {
			sum+=Integer.parseInt(num);
		} else {
			sum-=Integer.parseInt(num);
		}
		System.out.println(sum);
	} // end of main
} // end of class
