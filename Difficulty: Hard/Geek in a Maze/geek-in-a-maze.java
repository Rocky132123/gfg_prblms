import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        // Minimum upward moves used to reach each cell
        int[][] upUsed = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(upUsed[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();

        upUsed[r][c] = 0;
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            int currUp = upUsed[x][y];

            /*
             * Relation:
             *
             * downUsed - upUsed = x - r
             *
             * Therefore:
             *
             * downUsed = currUp + (x - r)
             */
            int currDown = currUp + (x - r);

            // ---------------- UP ----------------
            if (x - 1 >= 0 &&
                mat[x - 1][y] == '.' &&
                currUp + 1 <= u &&
                currUp + 1 < upUsed[x - 1][y]) {

                upUsed[x - 1][y] = currUp + 1;
                q.offer(new int[]{x - 1, y});
            }

            // ---------------- DOWN ----------------
            if (x + 1 < n &&
                mat[x + 1][y] == '.' &&
                currDown + 1 <= d &&
                currUp < upUsed[x + 1][y]) {

                upUsed[x + 1][y] = currUp;
                q.offer(new int[]{x + 1, y});
            }

            // ---------------- LEFT ----------------
            if (y - 1 >= 0 &&
                mat[x][y - 1] == '.' &&
                currUp < upUsed[x][y - 1]) {

                upUsed[x][y - 1] = currUp;
                q.offer(new int[]{x, y - 1});
            }

            // ---------------- RIGHT ----------------
            if (y + 1 < m &&
                mat[x][y + 1] == '.' &&
                currUp < upUsed[x][y + 1]) {

                upUsed[x][y + 1] = currUp;
                q.offer(new int[]{x, y + 1});
            }
        }

        // Count reachable cells
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (upUsed[i][j] != Integer.MAX_VALUE) {
                    ans++;
                }
            }
        }

        return ans;
    }
}