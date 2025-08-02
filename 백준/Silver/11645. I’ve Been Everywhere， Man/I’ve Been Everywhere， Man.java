import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t<T ;t++){
            int N = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            for(int i = 0 ; i<N ;i++){
                String s = br.readLine();
                set.add(s);
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    } // end of main
} // end of class