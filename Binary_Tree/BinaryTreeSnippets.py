def preorderTraversal(root):
    traversal = []

    def dfs(node):
        if not node:
            return
        traversal.append(node.val)  # root
        dfs(node.left)              # left
        dfs(node.right)             # right

    dfs(root)
    return traversal


def inorderTraversal(root):
    traversal = []

    def dfs(node):
        if not node:
            return
        dfs(node.left)              # left
        traversal.append(node.val)  # root
        dfs(node.right)             # right

    dfs(root)
    return traversal

def postorderTraversal(root):
    traversal = []

    def dfs(node):
        if not node:
            return
        dfs(node.left)
        dfs(node.right)
        traversal.append(node.val)

    dfs(root)
    return traversal


