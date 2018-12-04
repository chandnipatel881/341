import java.util.Random;

public class RBST {
        Random rand;
        public RBST() {
            rand = new Random(123456789);
        }

        private RBSTNode root;

        private RBSTNode rotateLeft(RBSTNode T){
            RBSTNode x = T.right;
            T.right = x.left;
            x.left = T;
            return x;
        }

        private RBSTNode rotateRight(RBSTNode T){
            RBSTNode x = T.left;
            T.left = x.right;
            x.right = T;
            return x;
        }

        private RBSTNode insertAtRoot(int x, RBSTNode T){
            if(T == null){
                return new RBSTNode(x, 1);
            }
            else if(x < T.getData()){
                T.left = insertAtRoot(x, T.left);
                T = rotateRight(T);
            }
            else if(x > T.getData()){
                T.right = insertAtRoot(x, T.right);
                T = rotateLeft(T);
            }
        return T;
        }

        private RBSTNode randomizedInsert(RBSTNode T, int value){
            if(T == null){
               RBSTNode t  = new RBSTNode(value,   1);
               rand.nextInt(t.getSize());
               return t;
            }
            //pick a random number, r, between 0 and the size of Tree, inclusive;
            int r = rand.nextInt(T.getSize() + 1);

            if(r == T.getSize()){
                T = insertAtRoot(value, T);
            }
            else{
                if(value < T.getData()){
                    T.left = randomizedInsert(T.left, value);
                }
                else {
                    T.right = randomizedInsert(T.right, value);
                 }
            }
            return T;
        }

        private int adjustSize(RBSTNode T){
            if(T == null){
                return 0;
            }
            T.setSize(1 + adjustSize(T.left) + adjustSize(T.right));
            return T.getSize();
        }

        public int height(RBSTNode root){
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
        private void printGivenLevel (RBSTNode root,int level)
        {
            if (root == null)
                return;
            if (level == 0)
                System.out.print(root.getData() + ","  + root.getSize() + " ");
            else if (level > 0)
            {
                printGivenLevel(root.left, level-1);
                printGivenLevel(root.right, level-1);
            }
        }

        public void insert(int value){
            root = randomizedInsert(this.root, value);
            adjustSize(root);
        }

    }

