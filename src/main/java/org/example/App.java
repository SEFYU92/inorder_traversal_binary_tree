package org.example;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.reverse;
import static java.util.stream.Collectors.toList;

/*
                   7
                /    \
               4      9
             /   \   / \
            2     6 8  10
           / \   /
          1   3 5
     */
public class App {
    public static void main(String[] args) {
        var nodesStack = new Stack<Integer>();
        var nodesList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.collectingAndThen(toList(), App::reverseList));
        nodesStack.addAll(nodesList);

        var depth = log2(nodesStack.size());
        System.out.println(depth);

        var numberOfMaxDepthNodes = nodesStack.size() - (Math.pow(2, depth) - 1);
        System.out.println(numberOfMaxDepthNodes);

        var node = new Node();
        node.buildTree(nodesStack, depth, depth);
    }

    private static List<Integer> reverseList(List<Integer> integers) {
        reverse(integers);
        return integers;
    }

    private static int log2(int length) {
        return (int) (Math.log(length) / Math.log(2));
    }
}
