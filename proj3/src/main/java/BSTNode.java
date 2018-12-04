import lombok.Getter;

public class BSTNode {

    public BSTNode left, right;
    @Getter
    private int data;

    public BSTNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("Data : " + this.data);
        return str.toString();
    }
}
