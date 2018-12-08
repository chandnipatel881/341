import java.io.InputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class proj4 {

    public static int MATRIX_SIZE;
    public static PriorityQueue<TaskAssignment> heap;
    public static int numPartialSolutions = 0;

    public static ArrayList<Coordinate> getDataFromFile(String args){
        InputStream file = proj4.class.getResourceAsStream(args);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        }catch(Exception e){
            System.out.println("File not found");
        }

        MATRIX_SIZE = Integer.parseInt(scanner.next());

        ArrayList<Coordinate> listOfCoordinates = new ArrayList<Coordinate>();

        while(scanner.hasNext()){
            for(int i = 1; i < MATRIX_SIZE + 1; i++){
                for(int j = 1; j < MATRIX_SIZE + 1; j++){
                    int cost = Integer.parseInt(scanner.next());
                    listOfCoordinates.add(new Coordinate(i,j,cost));
                }
            }
        }
        return listOfCoordinates;

    }

    public static void expandTaskAssignment(ArrayList<Coordinate> listOfCoordinates, PriorityQueue<TaskAssignment> heap, TaskAssignment taskAssignment){

        //If the taskAssignment doesn't have anything, add the 1st task into the heap
        if(taskAssignment.coordinatesList.size() == 0){
            for(Coordinate c : listOfCoordinates){
                if(c.getTask() == taskAssignment.getNextTask()){
                    TaskAssignment ta = new TaskAssignment(c);
                    numPartialSolutions++;
                    heap.add(ta);
                }
            }
        }
        else{
            for(Coordinate c : listOfCoordinates){
                if(c.getTask() == taskAssignment.getNextTask() && !taskAssignment.containsAgent(c.getAgent())){
                    TaskAssignment ta = new TaskAssignment(taskAssignment,c);
                    numPartialSolutions++;
                    heap.add(ta);

                }
            }
        }
    }

    public static TaskAssignment solution(ArrayList<Coordinate> listOfCoordinates) {
        heap = new PriorityQueue<TaskAssignment>();
        TaskAssignment taskAssignment;

        while (true) {
            taskAssignment = heap.poll();
            if(taskAssignment == null){
                taskAssignment = new TaskAssignment();
            }
            //Check if all tasks are in the list
            if ((taskAssignment.coordinatesList.size() == MATRIX_SIZE) ) {

                return taskAssignment;
            }
            expandTaskAssignment(listOfCoordinates, heap, taskAssignment);
        }

    }

    public static void main(String [] args){

        ArrayList<Coordinate> listOfCoordinates = new ArrayList<Coordinate>();
        listOfCoordinates =  getDataFromFile(args[0]);

        TaskAssignment taskAssignment = solution(listOfCoordinates);

        System.out.println("The number of agents: " + MATRIX_SIZE);
        System.out.println("The final size of openList: " + heap.size());
        System.out.println("The total number of partial solutions generated: " + numPartialSolutions);
        System.out.println("The solution found : " + taskAssignment.coordinatesList);
        System.out.println("The cost of the solution: " + taskAssignment.costOfTaskAssignment);

    }
}
