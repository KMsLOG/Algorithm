import java.util.*;

class Solution {
    static List<String> answer;
    static Set<Character> menu_set;
    static List<Character> menu;
    static int max_cnt;

    public List<String> solution(String[] orders, int[] course) {
        answer = new ArrayList<>();
        menu_set = new HashSet<>();

        for (String order : orders) {
            for (int i = 0; i < order.length(); i++) {
                menu_set.add(order.charAt(i));
            }
        }

        menu = new ArrayList<>(menu_set);
        Collections.sort(menu);

        for (int depth : course) {
            max_cnt = 0;
            Map<String, Integer> countMap = new HashMap<>();
            List<String> tmp = new ArrayList<>();

            dfs(0, 0, depth, new char[depth],orders, countMap);

            for (String key : countMap.keySet()) {
                int cnt = countMap.get(key);
                if (cnt == max_cnt && cnt >= 2) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    static void dfs(int depth, int start, int k, char[] tmp_menu,
                    String[] orders, Map<String, Integer> countMap) {
        if (depth == k) {
            String comb = new String(tmp_menu);
            int cnt = 0;

            for (String order : orders) {
                boolean flag = true;
                for (char c : comb.toCharArray()) {
                    if (!order.contains(String.valueOf(c))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }

            if (cnt >= 2) {
                countMap.put(comb, cnt);
                max_cnt = Math.max(max_cnt, cnt);
            }

            return;
        }

        for (int i = start; i < menu.size(); i++) {
            tmp_menu[depth] = menu.get(i);
            dfs(depth + 1, i + 1, k, tmp_menu, orders, countMap);
        }
    }
}
