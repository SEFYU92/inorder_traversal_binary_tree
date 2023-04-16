package org.example;

import java.util.Stack;

class Node {
    int value;
    Node parent;
    Node right;
    Node left;

    void buildTree(Stack<Integer> nodes, int currentDepth, int maxDepth) {
        if (left == null && currentDepth < maxDepth) {
            System.out.println("left child");
            left = new Node();
            left.parent = this;
            left.buildTree(nodes, currentDepth + 1, maxDepth);
        }

        value = nodes.pop();
        System.out.println("node " + value + " depth " + currentDepth);

        if (right == null && currentDepth < maxDepth) {
            System.out.println("right child");
            right = new Node();
            right.parent = this;
            right.buildTree(nodes, currentDepth + 1, maxDepth);
        }

        if (parent == null && currentDepth > 0) {
            System.out.println("parent");
            parent = new Node();
            parent.left = this;
            parent.buildTree(nodes, currentDepth - 1, maxDepth);
        }
    }
}
