public class AVLTree {
    Integer data;
    private AVLTree left;
    private AVLTree right;

    public AVLTree getLeft() {
        return left;
    }

    public void setLeft(AVLTree left) {
        this.left = left;
    }

    public AVLTree getRight() {
        return right;
    }

    public void setRight(AVLTree right) {
        this.right = right;
    }

    public AVLTree Search(int val)
    {
        if(data == null)
            return this;

        if(data == val)
            return this;

        if(val > data)
        {
            if(right == null)
                right = new AVLTree();
            return right.Search(val);
        }

        if(left == null)
            left = new AVLTree();
        return left.Search(val);
    }

    public AVLTree RotateLeft()
    {

    }





}
