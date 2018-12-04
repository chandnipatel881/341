import lombok.Getter;
import lombok.Setter;

public class RBSTNode {

    public RBSTNode left, right;
    @Getter
    @Setter
    private int data,size;

    public RBSTNode(int data, int size){
        this.data = data;
        this.size = size;
        this.left = null;
        this.right = null;
    }

    public void setSize(int size){
        this.size = size;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("Data : " + this.data);
        str.append("Size : " + this.size);
        return str.toString();
    }
}