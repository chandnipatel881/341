import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LLTest {

    @Test
    public void testInsert() {
        LL ll = new LL();
        ll.insert("Chandni");
        ll.insert(" ");
        ll.insert("Gaurang");
        String output = ll.toString();
        assertEquals(output, "Chandni ->   -> Gaurang -> ");
    }


}