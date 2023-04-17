package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.reverse;
import static java.util.stream.Collectors.toList;

/*
    input : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

                   7
                /    \
               4      9
             /   \   / \
            2     6 8  10
           / \   /
          1   3 5

    output : [7, 4, 9, 2, 6, 8, 10, 1, 3, 5]
*/
public class App {
    public static void main(String[] args) {
        var nodesStack = new Stack<Integer>();
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var nodesList = Stream.of(integers).collect(Collectors.collectingAndThen(toList(), App::reverseList));
        nodesStack.addAll(nodesList);

        var depth = log2(nodesStack.size());
        var maxDepth = new AtomicInteger(depth);
        System.out.println(depth);

        var numberOfMaxDepthNodes = new AtomicInteger((int) (nodesStack.size() - (Math.pow(2, depth) - 1)));
        System.out.println(numberOfMaxDepthNodes);

        var node = new Node();
        node.buildInorderTree(nodesStack, depth, maxDepth, numberOfMaxDepthNodes);
        var root = node.getRoot();
        var preorderTreeList = new ArrayList<Integer>(10);
        System.out.println("reading");
        root.readPreorderTree(preorderTreeList,10);
    }

    private static List<Integer> reverseList(List<Integer> integers) {
        reverse(integers);
        return integers;
    }

    private static int log2(int length) {
        return (int) (Math.log(length) / Math.log(2));
    }
}
