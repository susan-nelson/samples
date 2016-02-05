package com.susannelson;

import com.susannelson.domain.Node;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Susan on 11/11/2015.
 */
public class TreeUtilsTest {

    private TreeUtils classUnderTest;

    @BeforeClass
    public void setup() {

        classUnderTest = new TreeUtils();
    }

    @Test
    public void isBinarySearchTree_oneLevel(){

        Node leftNode = new Node(null, null, 2);
        Node rightNode = new Node(null, null, 12);
        Node tree = new Node(leftNode, rightNode, 10);

        boolean isBinaryTree = classUnderTest.isBinaryTree(tree);

        assertTrue(isBinaryTree);
    }

    @Test
    public void isBinarySearchTree(){

        Node leftNode1left = new Node(null, null, 1);
        Node leftNodeleft = new Node(leftNode1left, null, 2);
        Node leftNoderight = new Node(null, null, 5);
        Node leftNode = new Node(leftNodeleft, leftNoderight, 4);

        Node rightNode1left = new Node(null, null, 10);
        Node rightNodeleft = new Node(rightNode1left, null, 11);
        Node rightNoderight = new Node(null, null, 13);
        Node rightNode = new Node(rightNodeleft, rightNoderight, 12);

        Node tree = new Node(leftNode, rightNode, 10);

        boolean isBinaryTree = classUnderTest.isBinaryTree(tree);

        assertTrue(isBinaryTree);
    }

    @Test
    public void isBinarySearchTree_null(){

        boolean isBinaryTree = classUnderTest.isBinaryTree(null);

        assertFalse(isBinaryTree);
    }
}