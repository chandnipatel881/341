import lombok.Getter;

public class Stock {

    @Getter
    private int numOfStocks;
    @Getter
    private double latestPrice, averagePrice;
    private String ticker;

    public Stock(){
        this.latestPrice = 0;
        this.averagePrice = 0;
        this.ticker = null;
        this.numOfStocks = 0;
    }

    private double calculateAvgPrice(double price, int numStock){
        return ((this.numOfStocks * this.latestPrice) + (numStock * price))/(this.numOfStocks + numStock);
    }

    public void buyStock(String ticker, int numOfStocks, double latestPrice){
        this.averagePrice = calculateAvgPrice(latestPrice,numOfStocks);
        this.numOfStocks += numOfStocks;
        this.latestPrice = latestPrice;
        this.ticker = ticker;
    }

    public void sellStock(String ticker, int numOfStocks, double latestPrice){
        this.numOfStocks -= numOfStocks;
        this.latestPrice = latestPrice;
    }

    public void setLatestPrice(double latestPrice){
        this.latestPrice = latestPrice;
    }

    public String toString(){
        String str = new String();
        str = ticker + " " + numOfStocks + " " + String.format("%.2f",averagePrice) + " " + latestPrice + " ";
        str = str + (String.format("%.2f",(1 - (averagePrice/latestPrice)) * 100)) + "%";
        return str;
    }

}
