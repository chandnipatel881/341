public class BST {

    private BSTNode root;

    private BSTNode insertValue(BSTNode root, BSTNode newNode){
        if(root == null){
            return newNode;
        }
        else if(newNode.getData() < root.getData()){
            root.left = insertValue(root.left, newNode);
        }
        else if(newNode.getData() > root.getData()){
            root.right = insertValue(root.right, newNode);
        }
        return root;
    }

    public int height(BSTNode root){
        if(root == null){
            return 0;
        }
        else{
            int left_height = height(root.left);
            int right_height = height(root.right);

            return 1 + Math.max(left_height, right_height);
        }
    }

    /* function to print level order traversal of tree*/
    public void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=0; i<=h-1; i++) {
            System.out.print(" Level " + i + ": ");
            printGivenLevel(root, i);
            System.out.println();
        }
    }
    /* Print nodes at the given level */
    private void printGivenLevel (BSTNode root,int level)
    {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.getData() + " ");
        else if (level > 0)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    public void insert(int value){
        root = insertValue(this.root, new BSTNode(value));
    }

}
