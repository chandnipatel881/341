import java.util.HashMap;

public class Portfolio {

    private int totalCash;
    private HashMap<String,Stock> map = new HashMap<String, Stock>();

    public Portfolio(){
        this.totalCash = 0;
    }

    public void cashIn(int cash){
        this.totalCash += cash;
    }

    public void buy(String ticker, int numOfStocks, double stockPrice){
        //check if the map already has the stock
        if(!map.containsKey(ticker)){
            map.put(ticker, new Stock());
        }
        //check if the total balance is greater than or equal to amount purchasing
        if(totalCash >= numOfStocks * stockPrice) {
            map.get(ticker).buyStock(ticker, numOfStocks, stockPrice);
            totalCash -= numOfStocks * stockPrice;
        }
    }

    public void sell(String ticker, int numOfStocks, double stockPrice){
        map.get(ticker).sellStock(ticker,numOfStocks,stockPrice);
        totalCash += numOfStocks * stockPrice;
    }

    public void inputSharePrice(String ticker, double sharePrice){
        map.get(ticker).setLatestPrice(sharePrice);
    }

    public int getTotalCash(){
        for(String ticker: map.keySet()){
            totalCash += map.get(ticker).getNumOfStocks() * map.get(ticker).getLatestPrice();
        }
        return totalCash;
    }

    public Stock queryStock(String ticker){
        if(map.containsKey(ticker)){
            return map.get(ticker);
        }
        else{
            return null;
        }
    }

    public int getCountPortfolio(){
        return map.size();
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        if(map.isEmpty()){
            str.append("\tThe portfolio is empty");
            return str.toString();
        }
        for(String ticker: map.keySet()){
            str.append("\t" + map.get(ticker).toString());
            str.append("\n");
        }
        return str.toString();
    }
}
