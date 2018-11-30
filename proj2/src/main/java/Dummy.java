
import lombok.Getter;

import java.util.ArrayList;

public class Dummy<T> implements Comparable<Dummy<T>>{
    @Getter
    private ArrayList<T> listOfSequence = new ArrayList<T>();
    @Getter
    private int numOfOccurence;

    public Dummy(ArrayList<T> seq, int numOfOccurence){
        for(T obj : seq) {
            listOfSequence.add(obj);
        }
        this.numOfOccurence = numOfOccurence;
    }

    public int compareTo(Dummy obj){
        return obj.numOfOccurence - this.numOfOccurence;
    }

    public String toString(){
       StringBuffer str = new StringBuffer();
       for(int i = 0; i < listOfSequence.size(); i++) {
           str.append(this.listOfSequence.get(i));
       }
       return str.toString();
    }
}
