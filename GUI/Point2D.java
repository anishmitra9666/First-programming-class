/**
 * A 2 dimensional point with x and y coordinates and methods to get the coordinates and see if two points are equal.
 * @author Anish Mitra(axm949)
 */ 
public class Point2D extends Point{
  
  /** 
   * Creates a 2D point with x and y coordinates.
   * @param x2D The x-coordinate of the point.
   * @param y2D The y-coordinate of the point.
   */
  public Point2D(double x2D, double y2D){
    super(x2D, y2D, 0);
  }
  
  /**
   * Returns a string representation of the coordinates.
   * @return A string representation of the coordinates such as <code>(2.0, 3.0, 4.0)</code>
   */ 
  @Override
  public String toString(){
    return "(" + this.getX()  +  ","  +  this.getY() + ")";
  }
}
  
  