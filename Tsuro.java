import java.awt.Color;

public class Tsuro{
  
  /*
   * A constructor that creates a Tsuro game.
   */ 
  public Tsuro(){
    Board board = new Board(6, 6);
    PlayerHand playerhand1 = new PlayerHand(3, Color.BLACK, 6);
    PlayerHand playerhand2 = new PlayerHand(3, Color.GREEN, 2);
    board.setSize(600,600);
    playerhand1.setSize(300,125);
    playerhand2.setSize(300,125);
  }
  
  /*
   * A constructor that creates a Tsuro game with a board size of your choice.
   * @param row The number of rows in the baord
   * @param column The number of columns in the board. 
   */ 
  public Tsuro(int row, int column){
    Board board = new Board(row, column);
    PlayerHand playerhand1 = new PlayerHand(3, Color.BLACK, 6);
    PlayerHand playerhand2 = new PlayerHand(3, Color.GREEN, 2);
    board.setSize(600,600);
    playerhand1.setSize(300,125);
    playerhand2.setSize(300,125);
  }
  
  /*
   * A constructor that creates both a handsize and a board size of your choice.
   * @param handsize The number of tiles you have.
   * @param column The number of columns you have
   * @param row The number of rows you have.
   */ 
  public Tsuro(int handsize, int row, int column){
    Board board = new Board(row, column);
    PlayerHand playerhand1 = new PlayerHand(handsize, Color.BLACK, 6);
    PlayerHand playerhand2 = new PlayerHand(handsize, Color.GREEN, 2);
    board.setSize(600,600);
    playerhand1.setSize(300,125);
    playerhand2.setSize(300,125);
  }
}