import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Node {
    private String data;
    private Node next;
    private Node previous;

    Node(String data, Node next, Node previous){
        this.data = data;
        this.next = next;
        this.previous = previous;
    }


}
