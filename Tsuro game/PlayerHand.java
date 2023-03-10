import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.*;


/**
 * A helper class to create the hand of the player.
 * @author Anish Mitra axm949
 */ 
public class PlayerHand extends JFrame implements ActionListener{
  
  // The JPanel used to create the player's hands.
  private JPanel playerhand;
  
  // The tile which will comprise the player's hands.
  private final TsuroButton tsb;
  
  /** The constructor that creates the board.
    * @param handsize An int which specifies the number of tiles a player gets.
    * @param stoneColor The color of the stone specified by the class Color.
    * @param endPoint The Point on the tile the stone is placed on.
    */ 
  public PlayerHand(int handsize, Color stoneColor, int endPoint){
    playerhand = new JPanel(new GridLayout(1, handsize));
    TsuroButton[] buttons = new TsuroButton[handsize];
    for(TsuroButton tsb:buttons){
      tsb = new final TsuroButton();
      tsb.setSize(100,100);
      tsb.setConnections(TsuroButton.makeRandomConnectArray());
      tsb.addStone(stoneColor, endPoint);
      tsb.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          if (e.getSource() == tsb){
            ((TsuroButton)e.getSource()).setBackground(Color.YELLOW);
          }
          else
            ((TsuroButton)e.getSource()).setConnections(TsuroButton.makeRandomConnectArray());
        }
      });
      playerhand.add(tsb);
    }  
    add(playerhand);
    setVisible(true);
  }
  
  /*
   * A method to dictate the action performed during an action event such as a mouse click.
   * @param e An actionEvent such as a mouse click.
   * @return Returns nothing since it is void.
   */ 
  @Override 
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == tsb){
      ((TsuroButton)e.getSource()).setBackground(Color.YELLOW);
    }
    else
      ((TsuroButton)e.getSource()).setConnections(TsuroButton.makeRandomConnectArray());
  }
  
  /** A helper method which rotates the array  used to create a TsuroButton.
    * @param a A TsuroButton.
    * @return Returns the array of ints which is a 90 degree clockwise rotation of the array used to create the TsuroButton. 
    */ 
  public static int[] rotateArray(TsuroButton a){
    int[] original = a.getConnections();
    int[] rotated = new int[]{original[6], original[4], original[3], original[1]};
    return rotated;
  }
}  
