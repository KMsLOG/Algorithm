import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        for(int i = 0 ;i<N ;i++){
            sb.append(s.charAt(i));
            if(sb.length()>=K){
                boolean elimi = true;
                for(int j =1 ; j<K ; j++){
                    if(sb.charAt(sb.length()-1-j)!=sb.charAt(sb.length()-1)){
                        elimi = false;
                        break;
                    };
                }
                if(elimi){
                    sb.setLength(sb.length()-K);
                }
            }
        }
        System.out.println(sb);
    } // end of main
} // end of class