class Solution:
    def processQueries(self, arr, queries):
        n = len(arr)

        up = [0] * n
        down = [0] * n

        up[n - 1] = n - 1
        for i in range(n - 2, -1, -1):
            if arr[i] <= arr[i + 1]:
                up[i] = up[i + 1]
            else:
                up[i] = i

        down[n - 1] = n - 1
        for i in range(n - 2, -1, -1):
            if arr[i] >= arr[i + 1]:
                down[i] = down[i + 1]
            else:
                down[i] = i

        ans = []
        for l, r in queries:
            peak = min(up[l], r)
            ans.append(down[peak] >= r)

        return ans