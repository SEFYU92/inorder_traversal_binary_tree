package org.example;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

class Node {
    int value;
    Node parent;
    Node right;
    Node left;

    public void buildInorderTree(Stack<Integer> nodes, int currentDepth, AtomicInteger maxDepth, AtomicInteger lastLevelNodesNumber) {
        if (left == null && currentDepth < maxDepth.get()) {
            System.out.println("left child");
            left = new Node();
            left.parent = this;
            left.buildInorderTree(nodes, currentDepth + 1, maxDepth, lastLevelNodesNumber);
        }

        value = nodes.pop();
        if(currentDepth == maxDepth.get()){
            System.out.println("max depth reached");
            if (lastLevelNodesNumber.decrementAndGet() == 0) {
                System.out.println("all max depth nodes reached, change max depth");
                maxDepth.decrementAndGet();
            }

        }
        System.out.println("node " + value + " depth " + currentDepth);

        if (right == null && currentDepth < maxDepth.get()) {
            System.out.println("right child");
            right = new Node();
            right.parent = this;
            right.buildInorderTree(nodes, currentDepth + 1, maxDepth, lastLevelNodesNumber);
        }

        if (parent == null && currentDepth > 0) {
            System.out.println("parent");
            parent = new Node();
            parent.left = this;
            parent.buildInorderTree(nodes, currentDepth - 1, maxDepth, lastLevelNodesNumber);
        }
    }

    public Node getRoot() {
        if (this.parent != null) {
            return this.parent.getRoot();
        } else {
            return this;
        }
    }

/*
                   7
                /    \
               4      9
             /   \   / \
            2     6 8  10
           / \   /
          1   3 5
*/
    public void readPreorderTree(List<Integer> preorderTreeList, int size) {
        preorderTreeList.add(this.value);
        if (preorderTreeList.size() == size) {
            return;
        }
        if (this.left != null) {
            this.left.readPreorderTree(preorderTreeList,size);
        }
        if (this.right != null) {
            this.right.readPreorderTree(preorderTreeList,size);
        }
    }
}
