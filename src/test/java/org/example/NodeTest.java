package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
                   7
                /    \
               4      9
             /   \   / \
            2     6 8  10
           / \   /
          1   3 5
*/
class NodeTest {
    @Test
    void testTreeManagerInitialisation() {
        var treeManager = new TreeManager(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        assertEquals(treeManager.initTreeCharacteristics(), List.of(3, 3, 3));
    }

    @Test
    void tree_building_should_insert_all_passed_values() {
        var treeManager = new TreeManager(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        treeManager.initTreeCharacteristics();

        treeManager.buildInorderTree();

        assertEquals(0, treeManager.getValues().size());
    }

    @Test
    void getRoot() {
        var treeManager = new TreeManager(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        treeManager.initTreeCharacteristics();

        Node node = treeManager.buildInorderTree();

        assertEquals(7, node.getRoot().getValue());
    }

    @Test
    void readPreorderTree() {
        var treeManager = new TreeManager(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        treeManager.initTreeCharacteristics();
        Node node = treeManager.buildInorderTree();
        var root = node.getRoot();
        var preorderList = new ArrayList<Integer>(10);

        root.readPreorderTree(preorderList, 10);

        assertEquals(List.of(7, 4, 2, 1, 3, 6, 5, 9, 8, 10), preorderList);
    }
}