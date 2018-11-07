import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PortfolioTest {

    Portfolio portfolio = new Portfolio();
    @Test
    public void testBuy() {

        portfolio.cashIn(10000);
        portfolio.buy("MSFT", 20, 32.24);
        portfolio.buy("MSFT", 10,31.15);
        portfolio.buy("BAC",100,42.22);
        portfolio.buy("INTC",20,12.75);
        portfolio.inputSharePrice("BAC",43.35);
        portfolio.sell("BAC", 20, 43.35);
        System.out.println(portfolio.getTotalCash());
        System.out.println(portfolio);
    }
}