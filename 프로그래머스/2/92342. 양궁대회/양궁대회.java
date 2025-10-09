import java.util.*;

class Solution {
    static List<Integer> answer;
    static int maxDiff;

    public List<Integer> solution(int n, int[] info) {
        answer = new ArrayList<>();
        answer.add(-1);
        maxDiff = 0;
        dfs(0, n, info, new int[11]);
        return answer;
    }

    static void dfs(int depth, int remain, int[] info, int[] arrows) {
        if (depth == 11) {
            if (remain > 0) {
                arrows[10] += remain;
            }

            int ryan = 0;
            int apeach = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] == 0 && arrows[i] == 0) continue;

                if (arrows[i] > info[i]){
                    ryan += 10 - i;   
                } else {
                    apeach += 10 - i;
                }
            }

            if (ryan > apeach) {
                int diff = ryan - apeach;
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = new ArrayList<>();
                    for (int num : arrows){
                        answer.add(num);
                    }
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (arrows[i] > answer.get(i)) {
                            answer = new ArrayList<>();
                            for (int num : arrows){
                                answer.add(num);
                            }
                            break;
                        } else if (arrows[i] < answer.get(i)) break;
                    }
                }
            }

            if (remain > 0){
                arrows[10] -= remain;
            }
            return;
        }
        
        if (remain > info[depth]) {
            arrows[depth] = info[depth] + 1;
            dfs(depth + 1, remain - arrows[depth], info, arrows);
            arrows[depth] = 0;
        }

        dfs(depth + 1, remain, info, arrows);
    }
}
