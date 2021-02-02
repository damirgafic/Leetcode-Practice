import java.util.NoSuchElementException; 

public class Queue {
  private Node first; 
  private Node last; 
  private int length; 

  public Queue(){
    first = null; 
    last = null;
    length = 0;
  }
  public int peek(){
    if (length == 0){
      throw new NoSuchElementException();
    }
    return first.getValue;
  }
  public void enqueue(int value){
    Node newNode = new Node(value);
    if (length == 0){
      first = newNode;
    }
    else{
      last.setNext(newNode);
    }
    last = newNode; 
    length++; 
  }
  public void dequeue(){
    if (first == null){
      throw new NoSuchElementException();
    }
    first = first.getNext();
    length--;
    if (length == 0){
      last = null; 
    }
  }

}
