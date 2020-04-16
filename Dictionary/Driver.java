public class Driver {
  public static void main(String[] args){
    testBST();
  }

  public static void testBST(){
    BinarySearchTree<Character> bst = new BinarySearchTree<>();
    bst.addItem('G');
    bst.addItem('D');
    bst.addItem('B');
    bst.addItem('E');
    bst.addItem('A');
    bst.addItem('C');
    bst.addItem('F');
    bst.addItem('K');
    bst.addItem('N');
    bst.addItem('I');
    bst.addItem('L');
    bst.addItem('H');
    bst.addItem('J');
    bst.addItem('M');

    System.out.println("Original BST:");
    System.out.print("\tInorder traversal:\t");
    bst.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    bst.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    bst.postOrderTraverse();

    System.out.println("\tHeight of tree is: " +
    bst.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    bst.getRoot().getNumberOfNodes());

    System.out.println("Copy of Original BST:");
    BinarySearchTree<Character> copy = new BinarySearchTree<>(bst.getRoot().copy());
    System.out.print("\tInorder traversal:\t");
    copy.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    copy.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    copy.postOrderTraverse();
    System.out.println("\tHeight of tree is: " +
    bst.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    bst.getRoot().getNumberOfNodes());

    System.out.println("Testing contains:");
    System.out.println("\tcontains('H')?\t" + bst.contains('H'));
    System.out.println("\tcontains('A')?\t" + bst.contains('A'));
    System.out.println("\tcontains('X')?\t" + bst.contains('X'));

    System.out.println("Testing getItem:");
    System.out.println("\tgetItem('G'):\t" + bst.getItem('G'));
    System.out.println("\tgetItem('X'):\t" + bst.getItem('X'));

    System.out.println("\tcontains('H')?\t" + bst.contains('H'));

    System.out.println("After removing 'G' (" + bst.removeItem('G') + ") :");
    System.out.println("\tcontains('G')?\t" + bst.contains('G'));
    System.out.print("\tInorder traversal:\t");
    bst.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    bst.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    bst.postOrderTraverse();

    System.out.println("After removing 'M' (" + bst.removeItem('M') + ") :");
    System.out.println("After removing 'E' (" + bst.removeItem('E') + ") :");
    System.out.println("After removing 'N' (" + bst.removeItem('N') + ") :");

    System.out.print("\tInorder traversal:\t");
    bst.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    bst.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    bst.postOrderTraverse();

    System.out.println("\tHeight of tree is: " +
    bst.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    bst.getRoot().getNumberOfNodes());

    System.out.println("Copy of Original BST:");
    System.out.print("\tInorder traversal:\t");
    copy.inOrderTraverse();
    System.out.print("\tPreorder traversal:\t");
    copy.preOrderTraverse();
    System.out.print("\tPostorder traversal:\t");
    copy.postOrderTraverse();
    System.out.println("\tHeight of tree is: " +
    copy.getRoot().getHeight());
    System.out.println("\tNumber of nodes is: " +
    copy.getRoot().getNumberOfNodes());
  }
}
