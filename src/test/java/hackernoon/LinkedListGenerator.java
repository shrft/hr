package hackernoon;

class LinkedListGenerator{
    public LinkedElement run(Integer size){
        LinkedElement first = null;
        LinkedElement previous = null;
        for(Integer i=0; i < size; i++){
            LinkedElement element = new LinkedElement(i);
            if(first==null) first = element;
            if(previous!=null){
                previous.setNext(element);
            }
            previous=element;
        }
        return first;
    }
}
