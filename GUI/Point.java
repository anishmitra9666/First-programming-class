/**
 * A dimensional point with x, z and y coordinates and methods to get the coordinates and see if two points are equal.
 * @author Anish Mitra(axm949)
 */ 
public class Point{
  
  // The x-coordinate
  private double x;
  
  //The y-coordinate
  private double y;
  
  // The z-coordinate
  private double z;
  
  /** 
   * Creates a point with x, z and y coordinates.
   * @param x The x-coordinate of the point.
   * @param y The y-coordinate of the point.
   * @param z The z-coordinate of the point.
   */
  public Point(double x, double y, double z){
    super();
    this.x = x;
    this.y = y;
    this.z = z;
  }
    
  /**
   * Returns the x-coordinate of the point
   * @return The x-coordinate <code>x</code>.
   */
  public double getX(){
    return x;
  }
    
  /**
   * Returns the y-coordinate of the point
   * @return The y-coordinate <code>y</code>.
   */
  public double getY(){
    return y;
  }

  /**
   * Returns the z-coordinate of the point
   * @return The z-coordinate <code>z</code>.
   */
  public double getZ(){
    return z;
  }
  
  /**
   * Returns a string representation of the coordinates.
   * @return A string representation of the coordinates such as <code>(2.0, 3.0, 4.0)</code>
   */ 
  @Override
  public String toString(){
    return "(" + this.getX()  +  ","  +  this.getY() +  ","  +  this.getZ() + ")";
  }
  
  /**
   * Says if the two points have the same coordinates.
   * @param p1 Any object which is a reference type.
   * @return <code>true</code> if the points are the same, or <code>false</code> if the points are not the same or if the input is not a point.
   */ 
  @Override
  public boolean equals(Object p1){
    if (p1.getClass() == this.getClass() && ((Point)p1).getY() == this.getY() && ((Point)p1).getX() == this.getX() && ((Point)p1).getZ() == this.getZ())
      return true;
    else 
      return false;
  }
  
  /**
   * Finds the distance between the two points.
   * @param p1 A 2 dimensional point
   * @param p2 Another 2D point
   * @return The distance between the two points <code>p1</code> and <code>p2</code>.
   */ 
  public static double distance(Point p1, Point p2){ 
    return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p2.getY() - p2.getY(), 2) + Math.pow(p1.getZ() - p2.getZ(), 2));
  }
}
