import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StockTest {

    @Test
    public void testBuyStock() {
        Stock stock = new Stock();
        stock.buyStock("MSFT", 20, 32.24);
        stock.buyStock("MSFT", 10, 31.15);

        System.out.println(stock);
    }


}