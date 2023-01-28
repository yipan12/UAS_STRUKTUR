package com.binary.tree;

public class BinaryTree {
    public Node root;

    public void addNode(Node node) {
        if(root == null) {
            root = node;
        } else {
            insertNode(root, node);
        }
    }

    public void insertNode(Node parent, Node node) {
        if (parent.getValue() > node.getValue()) {
            if (parent.leftChild == null) {
                parent.leftChild = node;
            } else {
                insertNode(parent.leftChild, node);
            }
        } else {
            if(parent.rightChild == null) {
                parent.rightChild = node;
            } else {
                insertNode(parent.rightChild, node);
            }
        }
    }

    public static boolean searchValue(Node root, int value) {
        if (root == null) {
            return false;
        } else {
            if (root.getValue() == value) {
                return true;
            } else if (root.getValue() > value) {
                return searchValue(root.leftChild, value);
            } else {
                return searchValue(root.rightChild, value);
            }
        }
    }

    public void printNodes() {
        System.out.println(traversePreOrder(root));
    }

    public String traversePreOrder(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.rightChild != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.leftChild, root.rightChild != null);
        traverseNodes(sb, "", pointerRight, root.rightChild, false);

        return sb.toString();
    }

    public void traverseNodes(StringBuilder sb,
                              String padding,
                              String pointer,
                              Node node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.rightChild != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.leftChild, node.rightChild != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.rightChild, false);
        }
    }
}
