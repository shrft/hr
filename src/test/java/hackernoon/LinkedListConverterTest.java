package hackernoon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListConverterTest {
    @Test
    public void testStringifiedString(){
        LinkedElement elm = (new LinkedListGenerator()).run(3);
        String actual = (new LinkedListConverter()).stringify(elm);
        assertEquals("0,1,2", actual);
    }
}
