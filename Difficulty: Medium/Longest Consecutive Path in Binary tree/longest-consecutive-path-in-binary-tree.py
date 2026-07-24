class Solution:
    def longestConsecutive(self, root):
        self.ans = 0

        def dfs(node, length):
            if not node:
                return

            self.ans = max(self.ans, length)

            if node.left:
                if node.left.data == node.data + 1:
                    dfs(node.left, length + 1)
                else:
                    dfs(node.left, 1)

            if node.right:
                if node.right.data == node.data + 1:
                    dfs(node.right, length + 1)
                else:
                    dfs(node.right, 1)

        if not root:
            return -1

        dfs(root, 1)

        return self.ans if self.ans > 1 else -1