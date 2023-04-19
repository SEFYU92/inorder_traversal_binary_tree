package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeManager {
    private final Stack<Integer> values = new Stack<>();
    private final AtomicInteger depth = new AtomicInteger();
    private final AtomicInteger maxDepth = new AtomicInteger();
    private final AtomicInteger numberOfMaxDepthNodes = new AtomicInteger();

    public TreeManager(List<Integer> values) {
        Collections.reverse(values);
        this.values.addAll(values);
    }

    public List<Integer> initTreeCharacteristics() {
        this.depth.set(log2(values.size()));
        this.maxDepth.set(depth.get());
        this.numberOfMaxDepthNodes.set((int) (values.size() - (Math.pow(2, depth.get()) - 1)));
        return List.of(depth.get(), maxDepth.get(), numberOfMaxDepthNodes.get());
    }

    private static int log2(int length) {
        return (int) (Math.log(length) / Math.log(2));
    }
}
