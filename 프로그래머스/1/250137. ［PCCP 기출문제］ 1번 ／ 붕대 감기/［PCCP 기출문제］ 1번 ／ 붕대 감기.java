import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxT = bandage[0];
        int hPS = bandage[1];
        int addH = bandage[2];

        int maxHealth = health;

        int time = 0;
        int success = 0;

        for (int[] attack : attacks) {
            int aT = attack[0];
            int damage = attack[1];

            int diff = aT - time - 1;
            if (diff > 0) {
                success += diff;
                int tempHp = health + diff * hPS + (success / maxT) * addH;
                health = Math.min(tempHp, maxHealth);
                success %= maxT;
            }

            health -= damage;
            success = 0;
            time = aT;

            if (health <= 0) return -1;
        }
        return health;
    }
}
