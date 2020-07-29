public class BinarySearchTree {
    Integer data;
    private BinarySearchTree left,right;

    public BinarySearchTree getLeft()
    {
        return left;
    }
    public BinarySearchTree getRight()
    {
        return right;
    }
    public void SetLeft(BinarySearchTree node)
    {
        left = node;
    }
    public void SetRight(BinarySearchTree node)
    {
        right = node;
    }

    public void Insert(int val)
    {
        Search(val).data = val;
    }

    public BinarySearchTree Search(int val)
    {
        if(data == null)
            return this;

        if(data == val)
            return this;

        if(val > data)
        {
            if(right == null)
                right = new BinarySearchTree();
            return right.Search(val);
        }

        if(left == null)
            left = new BinarySearchTree();
        return left.Search(val);
    }

    public BinarySearchTree getBiggest()
    {
        BinarySearchTree temp = this;
        while(temp.right != null)
        {
            temp = temp.right;
        }

        if(temp.data == null)
            return null;
        return temp;
    }
    public BinarySearchTree getSmallest()
    {
        BinarySearchTree temp = this;
        while(temp.left != null)
        {
            temp = temp.left;
        }

        if(temp.data == null)
            return null;
        return temp;
    }

    public void Delete(int val)
    {
        BinarySearchTree temp = Search(val);
        if(temp.data == null)
            return;
        if(temp.left != null)
        {
            BinarySearchTree t2 = temp.left.getBiggest();
            temp.data = t2.data;
            t2.data = null;
        }
        else if(temp.right != null)
        {
            BinarySearchTree t2 = temp.right.getSmallest();
            temp.data = t2.data;
            t2.data = null;
        }
        else
            temp.data = null;
    }

    public void printInorder()
    {
        if(left != null)
            left.printInorder();
        System.out.print(this.data + " ");
        if(right != null)
            right.printInorder();
    }
    public void printPreOrder()
    {
        System.out.print(this.data + " ");
        if(left != null)
            left.printPreOrder();
        if(right != null)
            right.printPreOrder();
    }
    public void printPostOrder()
    {
        if(left != null)
            left.printPostOrder();
        if(right != null)
            right.printPostOrder();
        System.out.print(this.data + " ");
    }
}
