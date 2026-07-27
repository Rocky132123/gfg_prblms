class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class Solution:
    def constructBinaryTree(self, pre, preMirror):
        n = len(pre)

        # Store indices of mirror preorder
        pos = {}
        for i, val in enumerate(preMirror):
            pos[val] = i

        self.preIndex = 0

        def build(l, r):
            if self.preIndex >= n or l > r:
                return None

            root = Node(pre[self.preIndex])
            self.preIndex += 1

            # Leaf node
            if l == r or self.preIndex >= n:
                return root

            # Next preorder element is left child
            nextVal = pre[self.preIndex]

            # Position of left child in mirror preorder
            idx = pos[nextVal]

            # Build left subtree
            root.left = build(idx, r)

            # Build right subtree
            root.right = build(l + 1, idx - 1)

            return root

        return build(0, n - 1)