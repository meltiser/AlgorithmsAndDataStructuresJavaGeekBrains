package ru.grigorev.algorithms.lesson6;

public class Tree {

    private class TreeNode {
        private Integer c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Integer c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString() + " ";
        }
    }

    private TreeNode root;

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    public boolean isBalancedRec(TreeNode current) {
        if (current == null)
            return true;

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);

        boolean isSubtreeBalanced = Math.abs(leftHeight - rightHeight) <= 1;

        if (isSubtreeBalanced && isBalancedRec(current.left) && isBalancedRec(current.right))
            return true;
        else
            return false;
    }

    public int height(TreeNode current) {
        if (current == null)
            return 0;

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);
        if (leftHeight > rightHeight)
            return 1 + leftHeight;
        else
            return 1 + rightHeight;
    }

    public void insert(Integer c) {
        TreeNode node = new TreeNode(c);
        if (root == null)
            root = node;
        else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (c < current.c) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (c > current.c) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else
                    return;
            }
        }
    }

    public Integer find(int id) {
        TreeNode current = root;
        while (current.c != id) {
            current = (id < current.c) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    public void displayTree() {
        inOrderTravers(root);
    }

    private void inOrderTravers(TreeNode node) {
        if (node != null) {
            inOrderTravers(node.left);
            System.out.print(node);
            inOrderTravers(node.right);
        }
    }

    public boolean delete(int id) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        while (current.c != id) {
            parent = current;
            if (id < current.c) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        // if a leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // if has one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // if two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode current = node.right;

        while (current != null) {
            parent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }
}
