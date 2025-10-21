import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        List<int[]> combinations = new ArrayList<>();
        generateCombinations(n, 5, 1, new int[5], 0, combinations);

        int count = 0;
        for (int[] candidate : combinations) {
            if (isValid(candidate, q, ans)) {
                count++;
            }
        }
        return count;
    }

    private void generateCombinations(int n, int r, int start, int[] temp, int depth, List<int[]> result) {
        if (depth == r) {
            result.add(temp.clone());
            return;
        }
        for (int i = start; i <= n - (r - depth) + 1; i++) {
            temp[depth] = i;
            generateCombinations(n, r, i + 1, temp, depth + 1, result);
        }
    }

    private boolean isValid(int[] code, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int match = countMatches(code, q[i]);
            if (match != ans[i]) return false;
        }
        return true;
    }

    private int countMatches(int[] a, int[] b) {
        int count = 0;
        for (int x : a)
            for (int y : b)
                if (x == y) count++;
        return count;
    }
}
