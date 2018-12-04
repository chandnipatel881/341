import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class proj3 {

    public static void main(String[] args){

        int num_of_level = Integer.parseInt(args[0]);
        BST bst = new BST();
        RBST rbst = new RBST();

        InputStream file = proj3.class.getResourceAsStream(args[1]);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }catch(Exception e){
            System.out.println("File not found");
        }

        while(scanner.hasNext()){
            int i = Integer.parseInt(scanner.next());
            bst.insert(i);
            rbst.insert(i);
        }
        System.out.println("Regular BST : ");
        bst.printLevelOrder();
        System.out.println("Randomized BST : ");
        rbst.printLevelOrder();
    }
}

