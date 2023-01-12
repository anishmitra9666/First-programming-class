import junit.framework.TestCase;

public class TestLinkedList extends TestCase{
  
  public void testToArrayList(){
    LinkedList<WordData> llint = new LinkedList<WordData>();
    WordData[] a = new WordData[]{new WordData("A"), new WordData("B")};
    assertTrue(llint.toArrayList().contains(a));
  }
  
  public void testAddAfter(){
    LinkedList<WordData> llint = new LinkedList<WordData>();
    LLIterator<WordData> llIterator = llint.iterator();
    WordData abc = new WordData("A");
    WordData ac = new WordData("B");
    llint.addToFront(abc);
    llIterator.addAfter(ac);
    assertTrue((llint.toArrayList()).get(2) == ac);
  }
  
  public void testAddBefore(){
    LinkedList<WordData> llint = new LinkedList<WordData>();
    LLIterator<WordData> llIterator = llint.iterator();
    WordData ab = new WordData("B");
    WordData abc = new WordData("A");
    llint.addToFront(ab);
    llIterator.addBefore(abc);
    assertTrue(llint.toArrayList().get(1) == abc);
  }
}
  
