package Model;

import Model.ReportNode;

public class ReportTree {

    public ReportNode root;

    public void addNode(int orderId, Sale sale) {

        ReportNode newNode = new ReportNode(orderId, sale);

        if (root == null) {
            root = newNode;
        } else {

            ReportNode focusNode = root;
            ReportNode parent;

            while (true) {

                parent = focusNode;

                if (orderId < focusNode.orderId) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {

                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }

                }


            }

        }
    }

    public void inOrderTraverseTree(ReportNode focusNode) {

        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(ReportNode focusNode) {

        if (focusNode != null) {
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.leftChild);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(ReportNode focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            inOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public ReportNode findNode(int orderId) {
        ReportNode focusNode = root;
        while (focusNode.orderId != orderId) {
            if (orderId < focusNode.orderId) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }
}
