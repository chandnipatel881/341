import java.io.*;
import java.util.Scanner;

public class Proj1 {

    public static void main (String[] args){

        Portfolio portfolio = new Portfolio();
        File file = new File("target/classes/portfolio");
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch(Exception e) {
            System.out.println("File not found");
        }

        while(in.hasNextLine()){
            String line = in.nextLine();
            String[] splittedString = line.split(" ");
            System.out.println(line);
            if(line.equals("PRINTPORTFOLIO")){
                System.out.println(portfolio);
            }
            if(splittedString[0].equals("CASHIN")){
                portfolio.cashIn(Integer.parseInt(splittedString[1]));
                System.out.println("\tCurrent cash balance is " + portfolio.getTotalCash());
            }
            if(splittedString[0].equals("BUY")){
                portfolio.buy(splittedString[1],Integer.parseInt(splittedString[2]),Double.parseDouble(splittedString[3]));
                System.out.println("\t" + portfolio.queryStock(splittedString[1]));
            }
            if(splittedString[0].equals("QUERY")){
                if(portfolio.queryStock(splittedString[1]) == null){
                    System.out.println(("\tNo stock in portfolio with ticker " + splittedString[1]));
                }
                else{
                    System.out.println("\t" + portfolio.queryStock(splittedString[1]));
                }
            }
            if(splittedString[0].equals("SHAREPRICE")){
                portfolio.inputSharePrice(splittedString[1],Double.parseDouble(splittedString[2]));
            }
            if(splittedString[0].equals("SELL")){
                portfolio.sell(splittedString[1],Integer.parseInt(splittedString[2]),Double.parseDouble(splittedString[3]));
                System.out.println("\t" + portfolio.queryStock(splittedString[1]));
            }
            if(splittedString[0].equals("CASHBALANCE")){
                System.out.println("\tCurrent cash balance is " + portfolio.getTotalCash());
            }
            if(splittedString[0].equals("COUNTPORTFOLIO")){
                System.out.println("\t" + portfolio.getCountPortfolio());
            }
        }

    }

}
