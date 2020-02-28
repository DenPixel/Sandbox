package com.alevel.java.nix.level2.task2;

public class BinaryTreeNode {
    private int maxDepth = 0;
    TreeNode primary ;

    private TreeNode addRec(TreeNode tr, int val) {
        if (tr == null) {
            return new TreeNode(val);
        }

        if (val < tr.val) {
            tr.left = addRec(tr.left, val);
        } else if (val > tr.val) {
            tr.right = addRec(tr.right, val);
        } else {
            return tr;
        }

        return tr;
    }

    public void add(int val) {
        primary = addRec(primary, val);
        maxDepth = maxD(primary);
    }

    private int maxD(TreeNode tree){
        if (tree == null) {
            return 0;
        }

        return Math.max(maxD(tree.left), maxD(tree.right))+1;
    }

    public int getMaxDepth() {
        return maxDepth;
    }
}
