package com.algorithms.treeTraversal;

import com.dataStructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class PostOrderTraversal extends abstractTraversal {
    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            traverse(node.right);
            visit(node);
        }
    }
}