import junit.framework.TestCase;
import javax.swing.JFrame;

//Testing the Point class
public class Point extends TestCase{
  
  //Testing the toString() method of Point.
  public void testToString(){
    Point a = new Point(2,3,4);
    assertTrue("\"(2.0,3.0,4.0)\"" == a.toString());
  }
  
  //Testing the equals() method of Point.
  public void testEquals(){
    Point a = new Point(2,3,0);
    Point b = new Point(2,4,0);
    JFrame c = new JFrame();
    Point d = new Point(2,3,0);
    assertFalse("Tests a point and a JFrame", c.equals(a));
    assertFalse("Tests two different points such as (2,3,0) and (2,4,0)", b.equals(a));
    assertTrue("Tests if two (2,3,0) points are the same", d.equals(a));
  }
  
  //Testing the distance() method of Point.
  public void testDistance(){
    Point a = new Point(2,3,4);
    Point b = new Point(6,8,16);
    assertEquals("(2,3,4) and (6,8,16) have a distance of 13 between them.", 13, Point.distance(a,b), 0); 
  }
}