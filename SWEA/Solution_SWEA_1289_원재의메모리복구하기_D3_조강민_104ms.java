import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_SWEA_1289_원재의메모리복구하기_D3_조강민_104ms {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc<T;tc++) {
            String[] number = br.readLine().split(""); // 찾아야 될 메모리
            String[] initNum = new String[number.length]; // 초기값
            for(int ln = 0 ; ln<number.length;ln++) { // 초깃값 설정
                initNum[ln] = "0";
            }
             
            int cnt = 0; // 최소 수정 횟수
            int i = 0; // 인덱스 값
             
            while(i<number.length) { // 인덱스가 nuber 길이까지 될 때 까지 게속 반복
                if(number[i].equals(initNum[i])) { // 숫자 비교했을 때 같으면 
                    i++;    // 인덱스 ++
                    continue; // 넘어가기
                }
                 
                if(!(number[i].equals(initNum[i]))&&initNum[i].equals("0")) {
                    for(int k = i ; k<initNum.length;k++) {
                        initNum[k] = "1";
                    }
                    cnt++;
                    i++;
                } else if (!(number[i].equals(initNum[i]))&&initNum[i].equals("1")) {
                    for(int k = i ; k<initNum.length;k++) {
                        initNum[k] = "0";
                    }
                    cnt++;
                    i++;
                }
            } // end of while
             
            sb.append("#"+(tc+1)+" "+cnt+"\n");
        } // end of tc
        System.out.print(sb);
    } // end of main
} // end of class
