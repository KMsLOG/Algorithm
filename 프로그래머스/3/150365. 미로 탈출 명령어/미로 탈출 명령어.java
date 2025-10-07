class Solution {
    boolean[][][] visited;
    StringBuilder path = new StringBuilder();
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int minDist = Math.abs(x - r) + Math.abs(y - c);
        if (minDist > k) return "impossible";
        if ((k - minDist) % 2 != 0) return "impossible";

        visited = new boolean[n + 1][m + 1][k + 1];

        if (dfs(x, y, r, c, n, m, k))
            return path.toString();
        return "impossible";
    }

    private boolean dfs(int x, int y, int r, int c, int n, int m, int remain) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > remain) return false;
        if ((remain - dist) % 2 != 0) return false;

        if (remain == 0) return (x == r && y == c);

        if (visited[x][y][remain]) return false;
        visited[x][y][remain] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            path.append(dir[i]);
            if (dfs(nx, ny, r, c, n, m, remain - 1)) return true;
            path.deleteCharAt(path.length() - 1);
        }
        return false;
    }
}
