package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeManager {
    private final Deque<Integer> values;

    private final AtomicInteger depth;
    private final AtomicInteger maxDepth;
    private final AtomicInteger numberOfMaxDepthNodes;

    public TreeManager(List<Integer> values) {
        this.values = new LinkedList<>(values);
        depth = new AtomicInteger();
        maxDepth = new AtomicInteger();
        numberOfMaxDepthNodes = new AtomicInteger();
    }

    public Deque<Integer> getValues() {
        return values;
    }

    public List<Integer> initTreeCharacteristics() {
        this.depth.set(log2(values.size()));
        this.maxDepth.set(depth.get());
        this.numberOfMaxDepthNodes.set((int) (values.size() - (Math.pow(2, depth.get()) - 1)));
        return List.of(depth.get(), maxDepth.get(), numberOfMaxDepthNodes.get());
    }

    public Node buildInorderTree() {
        var node = new Node();
        node.buildInorderTree(values, depth.get(), maxDepth, numberOfMaxDepthNodes);
        return node;
    }

    private static int log2(int length) {
        return (int) (Math.log(length) / Math.log(2));
    }
}
