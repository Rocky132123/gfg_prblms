import java.util.*;

class Solution {
    public List<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;

        long[] prefix = new long[n];

        // Build prefix counts
        for (int i = 0; i < n; i++) {
            long count = (long) r[i] - l[i] + 1;

            if (i == 0) {
                prefix[i] = count;
            } else {
                prefix[i] = prefix[i - 1] + count;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int k : rank) {

            // Binary search for the interval containing rank k
            int low = 0;
            int high = n - 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int i = low;

            // Number of marks before this interval
            long before = (i == 0) ? 0 : prefix[i - 1];

            // Position inside current interval
            long position = k - before;

            // Corresponding mark
            int mark = (int)(l[i] + position - 1);

            ans.add(mark);
        }

        return ans;
    }
}