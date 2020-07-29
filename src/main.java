public class main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.Insert(10);
        tree.Insert(5);
        tree.Insert(2);
        tree.Insert(7);
        tree.Insert(15);
        tree.Insert(20);

        tree.printPostOrder();
        System.out.println();

        tree.Delete(20);
        tree.printInorder();
        System.out.println();

        tree.Insert(27);
        tree.printInorder();
        System.out.println();
    }
}
