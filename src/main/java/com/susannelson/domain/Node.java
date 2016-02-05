package com.susannelson.domain;

/**
 * Created by Susan on 11/11/2015.
 */
public class Node {

    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(Node leftNode, Node rightNode, int value) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}

