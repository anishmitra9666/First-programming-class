import java.util.*; 
  
public interface LLIterator<T> extends Iterator<T>{
  void addAfter(T element);
  void addBefore(T element);
}