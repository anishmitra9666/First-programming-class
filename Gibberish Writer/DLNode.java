public class DLNode<T> {
  private T element;
  private DLNode<T> next;
  private DLNode<T> previous;
  
  public DLNode(T element, DLNode<T> previous, DLNode<T> next) {
    this.element = element;
    this.next = next;
    this.previous = previous;
    if (next != null){
      next.setPrevious(this);
    }
    if (previous != null){
      previous.setNext(this);
    }
  }
  
  public T getElement() {
    return element;
  }
  
  public DLNode<T> getNext() {
    return next;
  }
  
  public void setNext(DLNode<T> next) {
    this.next = next;
  }
  
  public DLNode<T> getPrevious() {
    return previous;
  }
  
  public void setPrevious(DLNode<T> previous) {
    this.previous = previous;
  }
}