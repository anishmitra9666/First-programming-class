import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GibberishWriter{
  private ArrayList<ContextData> contextDataArrays;
  
  private int contextSize;
  
  public GibberishWriter(int contextSize, ArrayList<ContextData> contextDataArrays){
    this.contextSize = contextSize;
    this.contextDataArrays = new ArrayList<ContextData>();
  }
  
  public int getContextSize(){
    return contextSize;
  }
  
  public ContextData getContextData(int index){
    return contextDataArrays.get(index);
  }
  
  public static ContextData addContextData(Context conte, LinkedList<ContextData> linkedlistcd){
    LLIterator<ContextData> cditerator = linkedlistcd.iterator();
    ContextData cia = new ContextData(conte);
    while (cditerator.hasNext()){
      ContextData newcia = cditerator.next();
      if ((newcia.getContext()).compareTo(conte) == 0)
        return newcia;
      else if (conte.compareTo(newcia.getContext()) < 0){
        cditerator.addBefore(newcia);
        return newcia;
      }
      else{
        cditerator.addAfter(newcia);
        return newcia;
      }
    }
    linkedlistcd.addToFront(cia);
    return cia;
  }
  
  public void addDataFile(String fileName) throws FileNotFoundException{
    LinkedList<ContextData> llcd = new LinkedList<ContextData>();
    for (int i = contextDataArrays.size() - 1; i >= 0; i--){
      llcd.addToFront(this.getContextData(i));
      System.out.println(llcd);
    }
    Scanner scan = new Scanner(new File(fileName));
    String[] stringarray = new String[this.getContextSize()];
    scan.useDelimiter(" ");
    for (int i = 0; i < this.getContextSize(); i++){
      stringarray[i] = scan.next();
    }
    Context conte = new Context(stringarray);
    for (int j = 0; j < stringarray.length; j++){
      ContextData contextdata = addContextData(conte, llcd);
      contextdata.addFollowingWord(stringarray[j]);
      for (int k = 0; k < conte.length() && k > 0; k++){
        if (k == conte.length() - 1){
          stringarray[k] = stringarray[j];
        }
        else{
          stringarray[k] = stringarray[k-1];
        }
      }
      conte = new Context(stringarray);
    }
    scan.close();
    this.contextDataArrays = llcd.toArrayList();
  }
}