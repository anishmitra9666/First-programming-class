import junit.framework.TestCase;
import javax.swing.JFrame;

//Testing the Point2D class
public class Point2D extends TestCase{
  
  //Testing the toString() method of Point2D.
  public void testToString(){
    Point2D a = new Point2D(2,3);
    assertTrue("\"(2.0,3.0)\"" == a.toString());
  }
  
  //Testing the equals() method of Point2D.
  public void testEquals(){
    Point2D a = new Point2D(2,3);
    Point2D b = new Point2D(2,4);
    JFrame c = new JFrame();
    Point2D d = new Point2D(2,3);
    assertFalse("Tests a Point2D and a JFrame", c.equals(a));
    assertFalse("Tests two different Point2Ds such as (2,3) and (2,4)", b.equals(a));
    assertTrue("Sees if two (2,3) Point2Ds are the same", d.equals(a));
  }
  
  //Testing the distance() method of Point2D.
  public void testDistance(){
    Point2D a = new Point2D(2,3);
    Point2D b = new Point2D(6,8);
    assertEquals("(2,3) and (6,8) have a distance of 5 between them.", 5, Point2D.distance(a,b), 0); 
  }
}