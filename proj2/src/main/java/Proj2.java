import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Proj2 {

    private static Trie<Character> createTrie(File file, int depth){
        Scanner scanner = null;
        Trie<Character> trie = new Trie<Character>(depth);
        try {
            scanner = new Scanner(file);
        } catch(Exception e) {
            System.out.println("File not found");
        }
        while(scanner.hasNext()){
            String str = scanner.nextLine();

            for (int i = 0; i < str.length() - depth + 1; i++) {
                ArrayList<Character> substring = new ArrayList<Character>();
                for (int j = i; j < i + depth; j++) {
                    substring.add(str.charAt(j));
                }
                trie.insertIntoTrie(substring);
            }
        }
        return trie;
    }

    public static void main(String[] args){

        int depth = Integer.parseInt(args[0]);
        int num_of_substrings = Integer.parseInt(args[1]);

       File file1 = new File("target/classes/" + args[2]);
       File file2 = new File("target/classes/" + args[3]);
       //InputStream file3 = Proj2.class.getResourceAsStream(args[2]);

        Trie<Character> trie1 = createTrie(file1,depth);
        Trie<Character> trie2 = createTrie(file2,depth);

        ArrayList<Dummy<Character>> subStringsList = new ArrayList<Dummy<Character>>();
        subStringsList = trie1.allSubStrings(subStringsList);

        Collections.sort(subStringsList);


        System.out.println("Sequence     # in file1.txt     # in file2.txt");
        System.out.println("--------     --------------     --------------");
        for(int i = 0; i < subStringsList.size(); i++) {
            if(subStringsList.get(i).getNumOfOccurence() < subStringsList.get(num_of_substrings -1).getNumOfOccurence()){
                break;
            }
            Dummy dummy = subStringsList.get(i);
            int count = trie2.findOccurence(dummy.getListOfSequence());
            System.out.printf("%s          %d                  %d\n", dummy,dummy.getNumOfOccurence(),count);
        }
    }
}
