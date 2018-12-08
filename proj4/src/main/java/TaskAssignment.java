import java.util.ArrayList;

public class TaskAssignment implements Comparable<TaskAssignment>{

    public ArrayList<Coordinate> coordinatesList = new ArrayList<Coordinate>();
    public int costOfTaskAssignment;

    public TaskAssignment(){
    }

    public TaskAssignment(Coordinate coordinate){
        this.costOfTaskAssignment = coordinate.cost;
        this.coordinatesList.add(coordinate);
    }

    //Constructor that copies next coordinates for the taskAssignment solution
    public TaskAssignment(TaskAssignment obj, Coordinate coordinate){
        this.coordinatesList = new ArrayList<Coordinate>(obj.coordinatesList);
        this.coordinatesList.add(coordinate);
        this.costOfTaskAssignment = obj.costOfTaskAssignment + coordinate.cost;
    }

    public int compareTo(TaskAssignment obj){
        return this.costOfTaskAssignment - obj.costOfTaskAssignment;
    }

    public int getNextTask(){
        return this.coordinatesList.size()  + 1;
    }

    public boolean containsAgent(int agent){
        for(Coordinate c : coordinatesList){
            if (c.getAgent() == agent){
                return true;
            }
        }
        return false;
    }

    public boolean containsTask(int task){
        for(Coordinate c : coordinatesList){
            if (c.getTask() == task){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        for(Coordinate c : coordinatesList){
            str.append(c);
        }
        str.append(" cost :");
        str.append(this.costOfTaskAssignment);
        return str.toString();
    }

}
