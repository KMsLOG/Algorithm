import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<String> origin = new LinkedList<String>();
		String b[] = br.readLine().split("");
		
		for(String s:b) {
			origin.add(s);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		
		ListIterator<String> iter = origin.listIterator();
		
		while(iter.hasNext()) {
			iter.next();
		}
		
		while(n-- >0) {
			String command[] = br.readLine().split(" ");
			String firstCommand= command[0];
			
			
				if(firstCommand.equals("P")) 
				{
					iter.add(command[1]);
				}
				else if(firstCommand.equals("L")) 
				{
					if(iter.hasPrevious()) iter.previous();
				}
				else if(firstCommand.equals("D")) 
				{
					if(iter.hasNext()) iter.next();
				}
				else if(firstCommand.equals("B")) 
				{
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
		}
		System.out.println(String.join("", origin));
  	}
}