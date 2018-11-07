import lombok.Getter;
import lombok.NonNull;

@Getter
public class LL {

     private Node head, tail;
     private int size;

     public void insert(@NonNull String value){

         Node node = new Node(value, null, tail);

         //If the LL is empty, insert it at head and tail (see below)
         if(head == null){
             head = node;
         }

         //Point the current tail's next to new node
         if(tail != null) {
           tail.setNext(node);
         }

         //the new node will always be inserted at tail
         tail = node;
         size++;
     }

     public String toString(){
         StringBuffer str = new StringBuffer();

         Node temp = head;
         while(temp != null){
             str.append(temp.getData());
             str.append(" -> ");
             temp = temp.getNext();
         }
         return str.toString();
     }
}
