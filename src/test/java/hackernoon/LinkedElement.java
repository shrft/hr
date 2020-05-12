package hackernoon;

class LinkedElement{
    private Integer value;
    private LinkedElement next;
    public LinkedElement(Integer value){
        this.value = value;
    }

    public void setNext(LinkedElement next) {
        this.next = next;
    }
    public LinkedElement getNext(){ return this.next; }
    public Boolean hasNext(){ return this.next != null; }
    public LinkedElement getNthElement(Integer n){
        LinkedElement current = null;
        for(Integer i=0; i < n; i++){
            if(this.hasNext()){
                current = this.getNext();
            }else{
                return null;
            }
        }
        return current;
    }
    public Integer getValue(){
        return this.value;
    }
}
