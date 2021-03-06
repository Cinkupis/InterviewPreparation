package com.exercises.ctci.chapter4treesandgraphs;

import com.datastructures.trees.nodes.TreeNode;

@SuppressWarnings("unused")
public class ArrayToMinimalBSTree {

    public TreeNode convert(int[] array) {
        return addNode(0, array.length - 1, array);
    }

    private TreeNode addNode(int minIndex, int maxIndex, int[] array) {
        if (maxIndex < minIndex) {
            return null;
        }

        int midIndex = (minIndex + maxIndex) / 2;
        TreeNode node = new TreeNode(array[midIndex]);
        if (minIndex <= midIndex - 1) {
            node.left = addNode(minIndex, midIndex - 1, array);
        }

        if (midIndex + 1 <= maxIndex) {
            node.right = addNode(midIndex + 1, maxIndex, array);
        }

        return node;
    }
}
