class Solution:
    def find(self, arr):
        # code here
        x = 0

        for num in arr[::-1]:
            x = (x + num + 1) // 2

        return x
        