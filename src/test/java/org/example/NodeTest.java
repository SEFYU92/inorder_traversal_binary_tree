package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTest {
    @Test
    void testTreeManagerInitialisation() {
        var treeManager = new TreeManager(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        assertEquals(treeManager.initTreeCharacteristics(), List.of(3, 3, 3));
    }

    @Test
    void buildInorderTree() {
    }

    @Test
    void getRoot() {
    }

    @Test
    void readPreorderTree() {
    }
}