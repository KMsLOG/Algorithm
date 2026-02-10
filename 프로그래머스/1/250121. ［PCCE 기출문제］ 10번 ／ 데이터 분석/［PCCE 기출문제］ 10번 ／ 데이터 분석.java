import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        
        int standard = map.get(ext);
        for(int[] d : data){
            if(d[standard]<val_ext){
                answer.add(d);
            }
        }
        
        int sortStandard = map.get(sort_by);
        
        Collections.sort(answer,(o1,o2)->{
            return o1[sortStandard] - o2[sortStandard];
        });
        
        return answer;
    }
}