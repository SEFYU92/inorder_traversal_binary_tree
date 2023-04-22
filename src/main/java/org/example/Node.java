package org.example;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Node {
    int value;
    Node parent;
    Node right;
    Node left;

    public void buildInorderTree(Deque<Integer> nodes,
                                 int currentDepth,
                                 AtomicInteger maxDepth,
                                 AtomicInteger lastLevelNodesNumber) {
        if (left == null && currentDepth < maxDepth.get()) {
            left = new Node();
            left.parent = this;
            left.buildInorderTree(nodes, currentDepth + 1, maxDepth, lastLevelNodesNumber);
        }

        value = nodes.pop();
        if (currentDepth == maxDepth.get() && (lastLevelNodesNumber.decrementAndGet() == 0)) {
            maxDepth.decrementAndGet();
        }

        if (right == null && currentDepth < maxDepth.get()) {
            right = new Node();
            right.parent = this;
            right.buildInorderTree(nodes, currentDepth + 1, maxDepth, lastLevelNodesNumber);
        }

        if (parent == null && currentDepth > 0) {
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

    public void readPreorderTree(List<Integer> preorderTreeList, int size) {
        preorderTreeList.add(this.value);
        if (preorderTreeList.size() == size) {
            return;
        }
        if (this.left != null) {
            this.left.readPreorderTree(preorderTreeList, size);
        }
        if (this.right != null) {
            this.right.readPreorderTree(preorderTreeList, size);
        }
    }

    public int getValue() {

        return this.value;
    }
}
