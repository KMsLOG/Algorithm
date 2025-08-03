import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N ;i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int maxCnt = -1;

        for(int i= 0 ; i<N ; i++){
            double maxSlope = Double.NEGATIVE_INFINITY;
            int rightCnt = 0;
            int leftCnt = 0;
            for(int j = i-1; j>=0 ;j--){
                double slope = (double) (buildings[j]- buildings[i]) /(i-j);
                if(slope>maxSlope){
                    maxSlope = slope;
                    leftCnt++;
                }
            }
            maxSlope = Double.NEGATIVE_INFINITY;
            for(int k = i+1 ; k<N;k++){
                double slope = (double) (buildings[k] - buildings[i]) /(k-i);
                if(slope>maxSlope){
                    maxSlope = slope;
                    rightCnt++;
                }
            }
            if(maxCnt<leftCnt+rightCnt){
                maxCnt = leftCnt+rightCnt;
            }
        }
        System.out.println(maxCnt);
    } // end of main
} // end of class