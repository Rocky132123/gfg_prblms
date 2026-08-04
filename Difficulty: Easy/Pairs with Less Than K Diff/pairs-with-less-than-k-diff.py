class Solution:
    def countPairs(self, arr: list[int], k: int) -> int:
        # code here
        
      
        
        arr.sort()

        n = len(arr)
        left = 0
        ans = 0

        for right in range(n):

            while arr[right] - arr[left] >= k:
                left += 1

            ans += right - left

        return ans