class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        left =0
        right = len(colors)-1
        n =len(colors)
        ans =0
        for i in range(n):
            if colors[i] != colors[0]:
                ans = max(ans, i)

        for i in range(n):
            if colors[i] != colors[n - 1]:
                ans = max(ans, n - 1 - i)

        return ans
        