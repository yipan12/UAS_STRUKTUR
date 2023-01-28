package com.binary.tree;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addNode(new Node(10));
        tree.addNode(new Node(9));
        tree.addNode(new Node(15));
        tree.addNode(new Node(7));
        tree.addNode(new Node(6));
        tree.addNode(new Node(1));
        tree.addNode(new Node(11));

        System.out.println(BinaryTree.searchValue(tree.root, 5));

        tree.printNodes();
    }
}
