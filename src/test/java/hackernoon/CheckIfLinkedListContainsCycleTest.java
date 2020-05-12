package hackernoon;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://javarevisited.blogspot.com/2013/05/find-if-linked-list-contains-loops-cycle-cyclic-circular-check.html?source=post_page---------------------------
public class CheckIfLinkedListContainsCycleTest {
    public static void main(){

    }
    // 一番最初の要素にもどるかどうかではなく途中もチェックしないといけないのでは?
    // その場合はどういうふうに書くのか?
    public boolean isContainsCycle(LinkedElement firstElement) throws Exception {
        LinkedElement current = firstElement;
        if(!firstElement.hasNext()) return false;

        while(current.hasNext()){
            if(isExistBetween(current.getNext(), firstElement, current)){
                return true;
            }

            current = current.getNext();
        }
        return false;
    }
    private boolean isExistBetween(LinkedElement targetElement, LinkedElement firstElement, LinkedElement endElement) throws Exception {
        LinkedElement current = firstElement;
        while(current.hasNext()){
            if(current.getNext() == endElement){
                return false;
            }
            if(current.getNext() == targetElement){
                return true;
            }
            current = current.getNext();
        }
        throw new Exception("something went wrong!");
    }
    public boolean isContainCycleFloydApproach(LinkedElement firstElement){
        LinkedElement fast = firstElement;
        LinkedElement slow = firstElement;
        while(true){
            if(fast == slow){
                return true;
            }
            // ここで終了もチェックする
            if(!fast.hasNext() || !fast.getNext().hasNext()){
                return false;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
    }
    @Test
    public void checkIfLinkedListContainsCycleTest() throws Exception {
        Integer size = 2;
        CycleLinkedListGenerator gen = new CycleLinkedListGenerator();
        LinkedElement firstElement = gen.run(size);
        boolean actual = isContainsCycle(firstElement);
        assertEquals(true, actual);

        LinkedListGenerator linkedListGenerator = new LinkedListGenerator();

        firstElement = linkedListGenerator.run(3);
        LinkedElement third = getNthElement(firstElement, 2);
        third.setNext(
                firstElement.getNext()
        );
        actual = isContainsCycle(firstElement);
        assertEquals(true, actual);
    }
    @Test
    public void checkIfLinkedListContainsCycleFloydApproachTest() throws Exception {
        Integer size = 2;
        CycleLinkedListGenerator gen = new CycleLinkedListGenerator();
        LinkedElement firstElement = gen.run(size);
        boolean actual = isContainCycleFloydApproach(firstElement);
        assertEquals(true, actual);

        LinkedListGenerator linkedListGenerator = new LinkedListGenerator();
        firstElement = linkedListGenerator.run(3);
        LinkedElement third = getNthElement(firstElement, 2);
        third.setNext(firstElement.getNext());
        actual = isContainCycleFloydApproach(firstElement);
        assertEquals(true, actual);
    }
    private LinkedElement getNthElement(LinkedElement element, Integer n){
        LinkedElement current = element;
        for(Integer i=0; i < n; i++){
            if(current.hasNext()){
                current = current.getNext();
            }else{
                return null;
            }
        }
        return current;
    }
}