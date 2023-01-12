/*
 * A class to keep one or more word data and create a context by storing words in strings.
 * @author Anish Mitra
 */ 
public class Context implements Comparable<Context>{
  
  private String[] context;
  
  public Context(String[] context2){
    context = new String[context2.length];
    for (int i = 0; i < context2.length; i++){
      context[i] = context2[i];
    }
  }
  
  public String[] getArray(){
    return context;
  }
  
  public int length(){
    return context.length;
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < context.length; i++){
      sb.append(context[i] + " ");
    }
    return sb.toString();
  }
  
  public String getWord(int i){
    return context[i];
  }
  
  @Override
  public boolean equals(Object con){
    String[] conArray = ((Context)con).getArray();
    String[] thisArray = ((Context)this).getArray();
    int count = 0;
    if (con.getClass() == this.getClass()){
      if (((Context)con).length() == ((Context)this).length()){
        for (int i = 0; i < conArray.length; i++){
          if (conArray[i] == thisArray[i]){
            count = count + 1;
          }
        }
        if (count == conArray.length)
          return true;
        else 
          return false;
      }
      else 
        return false;
    }
    else
      return false;
  }
  
  public int compareTo(Context other){
    int i = 0;
    int compare = 0;
    while (i < context.length){
      compare = this.getWord(i).compareTo(other.getWord(i));
      if (compare == 0){
        if (i == this.length() || i == other.length())
          return compare;
        i = i + 1;
      }
      else{
        return compare;
      }
    }
    return compare;
  }  
}


