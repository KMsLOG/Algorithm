import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] nums = s.split("[^0-9]+");
        
        Map<Integer, Integer> counts = new HashMap<>();
        
        String temp = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                temp += c;
            } else {
                if (!temp.equals("")) {
                    int num = Integer.parseInt(temp);
                    counts.put(num, counts.getOrDefault(num, 0) + 1);
                    temp = "";
                }
            }
        }

        List<Integer> list = new ArrayList<>(counts.keySet());
        list.sort((a, b) -> counts.get(b).compareTo(counts.get(a)));

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}