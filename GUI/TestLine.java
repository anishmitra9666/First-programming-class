import junit.framework.TestCase;
import javax.swing.JFrame;

//Testing the Line class.
public class Line extends TestCase{
  
  //Testing the toString() method of Line
  public void testToString(){
    Point a = new Point(2,3,4);
    Point b = new Point(3,4,5);
    Line line1 = new Line(a,b);
    assertTrue("x = 2.0 + 1.0t,\n y = 3.0 + 1.0t,\n z = 4.0 + 1.0t" == line1.toString());
  }
  
  // Testing the equals() method of Line.
  public void testEquals(){
    Point a = new Point(2,3,4);
    Point b = new Point(4,5,6);
    JFrame c = new JFrame();
    Point d = new Point(3,5,6);
    Point e = new Point(2,3,4);
    Line line1 = new Line(a,b);
    Line line2 = new Line(a,d);
    Line line3 = new Line(b,e);
    assertFalse("Should return false for different lines", line1.equals(line2));
    assertTrue("Should return true for same line", line3.equals(line1));
    assertFalse("Should return false for different objects", line1.equals(c));
  }
  
  // Testing the isParallel() method of Line.
  public void testIsParallel(){
    Point a = new Point(2,3,4);
    Point b = new Point(4,5,6);
    Point c = new Point(4,5,6);
    Point d = new Point(8,10,12);
    Point e = new Point(4,5,9);
    Line line1 = new Line(a,b);
    Line line2 = new Line(d,e);
    Line line3 = new Line(a,d);
    Line line4 = new Line(a,c);
    assertFalse("Should not return true for the same line", Line.isParallel(line1, line4));
    assertFalse("Should not return true for different lines with different vectors", Line.isParallel(line1, line2));
    assertTrue("Should return true for same line with different vectors.", Line.isParallel(line3, line4));
  }
  
  // Testing the intersection() method of Line.
  public void testIntersection(){
    Point a = new Point(2,3,4);
    Point b = new Point(3,4,5);
    Point c = new Point(5,6,7);
    Point d = new Point(3,4,5);
    Point e = new Point(4,5,6);
    Line line1 = new Line(a,b);
    Line line2 = new Line(b,e);
    Line line3 = new Line(a,d);
    Line line4 = new Line(e,c);
    assertSame("Should return intersection for different non-parallel lines.", Line.intersection(line1, line2), a);
    assertNull("Infinite points of intersection for same line", Line.intersection(line3, line1));
    assertNull("No intersection for parallel lines", Line.intersection(line4, line1));
  }
}