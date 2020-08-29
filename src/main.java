import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.println("1)Insert 2)Delete 3)Print 4)Exit");
            int menu = input.nextInt();

            switch (menu)
            {
                case 1:
                {
                    System.out.println("Enter a insert value");
                    int val = input.nextInt();
                    tree.root = tree.Insert(tree.root,val);
                }
                break;
                case 2:
                {
                    System.out.println("Enter a delete value");
                    int val = input.nextInt();
                    tree.root = tree.Delete(tree.root, val);
                }
                break;
                case 3:
                {
                    System.out.println("1) Inorder 2) Postorder 3) preorder");
                    int m2 = input.nextInt();
                    if(m2 == 1)
                        tree.printInorder(tree.root);
                    else if(m2 == 2)
                        tree.printPostOrder(tree.root);
                    else
                        tree.printPreOrder(tree.root);
                }
                break;
                case 4:
                {
                    System.exit(0);
                }
                break;
                default:
                    System.out.println("Wrong Input");
            }
            System.out.println();
        }
    }
}
