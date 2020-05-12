package hackernoon;
import org.junit.jupiter.api.Test;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseLinkedListTest {
    // 通常の処理
    // 再起処理の両方で書く
    public LinkedElement reverseLinkedList(LinkedElement elm){
        LinkedElement current = elm;
        LinkedElement prev = new LinkedElement(current.getValue());
        while(current.hasNext()){
            current = current.getNext();
            LinkedElement next = new LinkedElement(current.getValue());
            next.setNext(prev);
            prev = next;
        }
        return prev;
    }
    public LinkedElement reverseLinkedListRecursively(LinkedElement elm, LinkedElement previous){
        if(elm.hasNext()){
            LinkedElement next = new LinkedElement(elm.getNext().getValue());
            if(previous==null){
                previous = new LinkedElement(elm.getValue());
            }
            next.setNext(previous);
            return reverseLinkedListRecursively(elm.getNext(), next);
        }else{
            return previous;
        }
    }
    @Test
    public void reverseLinkedListTest(){
        LinkedListGenerator gen =  new LinkedListGenerator();
        LinkedElement elm = gen.run(3);
        LinkedElement reversedElm = reverseLinkedList(elm);
        String actual = (new LinkedListConverter()).stringify(reversedElm);
        assertEquals("2,1,0", actual);
    }
    @Test
    public void reverseLinkedListTestRecursively(){
        LinkedListGenerator gen =  new LinkedListGenerator();
        LinkedElement elm = gen.run(3);
        LinkedElement reversedElm = reverseLinkedListRecursively(elm, null);
        String actual = (new LinkedListConverter()).stringify(reversedElm);
        assertEquals("2,1,0", actual);
    }
}
