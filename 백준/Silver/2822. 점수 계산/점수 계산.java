import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		int minidx = 0;
		for(int i = 1 ; i<9;i++) {
			int number = sc.nextInt();
			if(map.size() > 4 ) {
				if(number>min) {
					map.remove(minidx);
					map.put(i, number);
					min = Integer.MAX_VALUE;
					for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
						if(min>entry.getValue()) {
							min = entry.getValue();
							minidx = entry.getKey();
						}
					}
				} 
				
				
			} else {
				map.put(i, number);
				for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
					if(min>entry.getValue()) {
						min = entry.getValue();
						minidx = entry.getKey();
					}
				}
			}
			
		}
		int sum = 0;
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			sum +=entry.getValue();
		}
		System.out.println(sum);
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey()+" ");
		}
		
		
		
	} // end of main
} // end of class
