import java.util.ArrayList;
import java.util.HashMap;

public class Trie<T> {

    private TrieNode<T> root;
    private int depth;

    public Trie(int depth){
        root = new TrieNode(null);
        this.depth = depth;
    }

    public void insertIntoTrie(ArrayList<T> sequence) {
        if (sequence.size() != depth) {
            throw new IllegalStateException("Size of the sequence has to be equal to the depth");
        }
        root.count++;
        TrieNode<T> currentNode = root;
        for (int i = 0; i < sequence.size(); i++) {
            if(!currentNode.children.containsKey(sequence.get(i))){
                currentNode.children.put(sequence.get(i), new TrieNode<T>(sequence.get(i)));
            }
            currentNode = currentNode.children.get(sequence.get(i));
            currentNode.count++;
        }
    }

    private void allSubStringsImpl(ArrayList<Dummy<T>> list, TrieNode<T> currentNode, ArrayList<T> seq){
        if(currentNode.children.isEmpty()){
            list.add(new Dummy<T>(seq,currentNode.count));
            return;
        }
        TrieNode<T> ParentNode = currentNode;
        for(T nodeData : currentNode.children.keySet()) {
            currentNode = currentNode.children.get(nodeData);
            seq.add(currentNode.data);
            allSubStringsImpl(list, currentNode,seq);
            seq.remove(seq.size() - 1);
            currentNode = ParentNode;
        }
    }

    public ArrayList<Dummy<T>> allSubStrings(ArrayList<Dummy<T>> list) {
        allSubStringsImpl(list, this.root, new ArrayList<T>());
        return list;
    }

    public int findOccurence(ArrayList<T> seq){
        TrieNode<T> currentNode = this.root;
        for(int i = 0; i < seq.size(); i++){
            currentNode = currentNode.children.get(seq.get(i));
            if (currentNode == null){
                return 0;
            }
        }
        return currentNode.count;
    }


    private class TrieNode<T> {

        private int count;
        private T data;
        //Key is the children data
        //Value is the children node
        private HashMap<T, TrieNode<T>> children = new HashMap<T, TrieNode<T>>();

        public TrieNode(T data) {
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }

    }
}

