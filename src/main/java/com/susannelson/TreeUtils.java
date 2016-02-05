package com.susannelson;

import com.susannelson.domain.Node;

/**
 * Created by Susan on 11/11/2015.
 */
public class TreeUtils {

    public boolean isBinaryTree(Node n) {

        if (n == null) {
            return false;
        }

        return isBinarySearchTree(n);
    }

    private boolean isBinarySearchTree(Node n){

        if (n == null) {
            return true;
        }

        boolean isBinaryTree = false;

        if (n.getLeftNode() != null) {

            if ( n.getLeftNode().getValue() < n.getValue()){

                isBinaryTree = isBinarySearchTree(n.getLeftNode());
            }
        } else {
            isBinaryTree = true;
        }

        if (isBinaryTree) {

            if (n.getRightNode() != null) {

                if (n.getRightNode().getValue() >= n.getValue()) {

                    return isBinarySearchTree(n.getRightNode());
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        else {
            return false;
        }

    }
}
