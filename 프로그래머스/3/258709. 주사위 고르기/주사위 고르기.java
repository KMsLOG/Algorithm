import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;
        List<int[]> combi = new ArrayList<>();
        int[] result = new int[half];
        long max_win = -1;

        combine(0, n, half, new ArrayList<>(), combi);
        
        for(int[] a_combi : combi){
            int[] b_combi = new int[half];
            boolean[] used = new boolean[n];
            
            for(int a_dice : a_combi){
                used[a_dice] = true;
            }
            
            int b_idx = 0;
            for(int i = 0 ;i<n ;i++){
                if(!used[i]){
                    b_combi[b_idx]=i;
                    b_idx++;
                }
            }
            
            List<Integer> a_sum = new ArrayList<>();
            List<Integer> b_sum = new ArrayList<>();
            arraySum(a_sum,a_combi,dice,0,0);
            arraySum(b_sum,b_combi,dice,0,0);
            
            Collections.sort(a_sum);
            Collections.sort(b_sum);
            
            long a_win = 0;
            int j = 0;
            
            for(int a : a_sum){
                while(j<b_sum.size() && b_sum.get(j)<a){
                    j++;
                }
                a_win+=j;
            }
            
            if(max_win<a_win){
                for(int i = 0 ; i<half;i++){
                    result[i] = a_combi[i]+1;
                }
                max_win = a_win;
            }
        }
        return result;
    }
    
    private void arraySum(List<Integer> array_sum,int[] comb, int[][] dice, int start, int t_sum){
        if(start == comb.length){
            array_sum.add(t_sum);
            return;
        }
        
        for(int i = 0 ;i<6 ;i++){
            t_sum+=dice[comb[start]][i];
            arraySum(array_sum,comb,dice,start+1,t_sum);
            t_sum-=dice[comb[start]][i];
        }
    }


    private void combine(int start, int n, int r, List<Integer> cur, List<int[]> combi) {
        if (cur.size() == r) {
            int[] arr = new int[r];
            for (int i = 0; i < r; i++){
                arr[i] = cur.get(i);   
            }
            combi.add(arr);
            return;
        }
        for (int i = start; i < n; i++) {
            cur.add(i);
            combine(i + 1, n, r, cur, combi);
            cur.remove(cur.size() - 1);
        }
    }
}