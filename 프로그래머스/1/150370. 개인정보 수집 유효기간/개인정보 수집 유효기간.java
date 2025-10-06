import java.util.*;
import java.io.*;
class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 약관 정보 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (String t : terms) {
            String[] split = t.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        int todayDays = dateToDays(today);

        // 파기
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String date = split[0];
            String type = split[1];

            int dateDays = dateToDays(date);
            int termMonths = map.get(type);

            int expireDate = dateDays + (termMonths * 28) - 1;

            if (expireDate < todayDays) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
    
    // 일 수로 변환
    private int dateToDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return year * 12 * 28 + month * 28 + day;
    }

}