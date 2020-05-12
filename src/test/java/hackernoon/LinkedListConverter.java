package hackernoon;

public class LinkedListConverter {
    public String stringify(LinkedElement startElement){
        LinkedElement current = startElement;
        String str = current.getValue().toString();
        while(current.hasNext()){
            current = current.getNext();
            str += "," + current.getValue().toString();
        }
        return str;
    }
}
