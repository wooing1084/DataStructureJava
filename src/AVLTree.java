public class AVLTree {
    public class Node
    {
        Integer data;
        private Node left;
        private Node right;
        private int height;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setHeight(int h)
        {
            height = h;
        }
        public int getHeight()
        {
            return height;
        }
    }

    public Node root;

    public Node Search(int val)
    {
        return Search(root,val);
    }

    private Node Search(Node root, int val)
    {
        if(root.data == null)
            return root;

        if(root.data == val)
            return root;

        if(val > root.data)
        {
            if(root.right == null)
                root.right = new Node();
            return Search(root.right, val);
        }

        if(root.left == null)
            root.left = new Node();
        return Search(root.left , val);
    }

    public Node Insert(Node root, int val)
    {
        if(root == null) {
            root = new Node();
            root.data = new Integer(val);
        }
        else
        {
            if(val > root.data)
            {
                root.right = Insert(root.right,val);
                root = setBalance(root);
            }
            else
            {
                root.left = Insert(root.left,val);
                root = setBalance(root);
            }
        }

        return root;
    }

    private Node setBalance(Node root)
    {
        int bf = getBf(root);
        if(bf >= -2)
        {
            if(getBf(root.left) >= 1)
                root = LL(root);
            else
                root = LR(root);
        }
        else if(bf <= -2)
        {
            if(getBf(root.right) <= -1)
                root = RR(root);
            else
                root = RL(root);
        }
        setHeight(root);
        return root;
    }

    private int setHeight(Node root)
    {
        int lh = 0,rh = 0;

        if(root.left != null)
            lh = root.left.height + 1;
        if(root.right != null)
            rh = root.right.height + 1;

        return lh > rh ? lh : rh;
    }

    private int getBf(Node root)
    {
        int lf = 0, rf = 0;
        if(root.left != null)
            lf = root.left.height;
        if(root.right != null)
            rf = root.right.height;
        return lf - rf;
    }


    private Node RotateRight(Node root)
    {
        int h = root.height;
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;

        temp.setHeight(h);

        return temp;
    }

    private Node RotateLeft(Node root)
    {
        int h = root.height;
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;

        temp.setHeight(h);

        return temp;
    }

    private Node RR(Node root)
    {
        root = RotateLeft(root);
        return root;
    }

    private Node LL(Node root)
    {
        root= RotateRight(root);
        return root;
    }

    private Node LR(Node root)
    {
        root.left = RotateLeft(root.left);
        root = RotateRight(root);
        return root;
    }

    private Node RL(Node root)
    {
        root.right = RotateRight(root.right);
        root = RotateLeft(root);
        return root;
    }

    public void printInorder(Node root)
    {
        if(root.left != null)
            printInorder(root.left);
        System.out.print(this.root.data + " ");
        if(root.right != null)
            printInorder(root.right);
    }
    public void printPreOrder(Node root)
    {
        System.out.print(this.root.data + " ");
        if(root.left != null)
            printPreOrder(root.left);
        if(root.right != null)
            printPreOrder(root.right);
    }
    public void printPostOrder(Node root)
    {
        if(root.left != null)
            printPostOrder(root.left);
        if(root.right != null)
            printPostOrder(root.right);
        System.out.print(this.root.data + " ");
    }
}
