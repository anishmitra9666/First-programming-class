public class WordData{
  
  private String word;
  
  private int count;
  
  public WordData(String word){
    this.word = word;
    this.count = 1;
  }
  
  public void incrementCount(){
    this.count = count + 1;
  }
  
  public String getWord(){
    return word;
  }
  
  public int getCount(){
    return count;
  }
}