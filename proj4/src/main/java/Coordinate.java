import lombok.Getter;
import lombok.Setter;

@Getter
public class Coordinate {

    public int agent;
    public int task;
    public int cost;

    public Coordinate(){

    }

    public Coordinate(int x, int y, int cost){
        this.agent = x;
        this.task = y;
        this.cost = cost;
    }

    public String toString(){
        return "(" + this.agent + ", " + this.task  + ")";
    }
}

