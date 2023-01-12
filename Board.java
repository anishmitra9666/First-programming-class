import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

/**
 * A helper class to create the board.
 * @author Anish Mitra axm949
 */ 
public class Board extends JFrame{
  
  // The JPanel used to create the board. 
  private JPanel board;
  
  /** The constructor that creates the board.
    * @param row A parameter of type int which specifies the number of rows on the board.
    * @param column A parameter of type int which specifies the number of columns on the board.
    */ 
  public Board(int row, int column){
    board = new JPanel(new GridLayout(row, column));
    for(int i=1;i<=row;i++){
      for(int j=1;j<=column;j++){
        TsuroButton tsb = new TsuroButton();
        tsb.setSize(100,100);
        board.add(tsb);
      }
    }
    add(board);
    setVisible(true);
  }
}