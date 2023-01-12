/**
 * A plane is a vector extended to another point.
 * @author Anish Mitra(axm949)
 */ 
public class Plane{
  // The start point of the plane or the vector from the origin to this point.
  private Point p1;
  
  //One of the two additional points used to construct a plane.
  private Point p2;
  
  //The other point used to construct a plane.
  private Point p3;

  /**
   * Creates a plane from the three points inputed.
   * @param p1 the first input of type point.
   * @param p2 the second input of type point.
   * @param p3 the third input of type point. 
   */ 
  public Plane(Point p1, Point p2, Point p3){
    super();
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }
  
  /**
   * Creates a plane from a point and a vector.
   * @param p1 the first input of type point.
   * @param vector The second input which is of type vector.
   */ 
  public Plane(Point p1, Vector vector){
    super();
    this.p1 = p1;
  }
  
  /**
   * A helper getter method to get the start point of the plane.
   * @return Returns the start point of the plane in the type plane.
   */
  public Point getStartPoint(){
    return p1;
  }
  
  /**
   * A helper method to get the parameter d for the plane.
   * @return A value of type double which is the parameter d.
   */
  public double getD(){
    return ((this.getNormal()).getX() * (this.p1).getX()) + ((this.getNormal()).getY() * (this.p1).getY()) + ((this.getNormal()).getZ() * (this.p1).getZ());
  }
  
  /**
   * Returns the normal vector to the plane.
   * @return A normal vector.
   */
  public Vector getNormal(){
    Vector v1 = new Vector(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
    Vector v2 = new Vector(p3.getX() - p1.getX(), p3.getY() - p1.getY(), p3.getZ() - p1.getZ());
    return Vector.crossProduct(v1, v2);
  }
  
  /**
   * Returns a string representation of the plane.
   * @return A string representation of the plane such as <code>"2.0x - 1.0y + 4.0z - 24 = 0"</code>
   */ 
  @Override
  public String toString(){
    if (this.getD() > 0)
      return "\"" + (this.getNormal()).getX() + "x + " + (this.getNormal()).getY() + "y + " + (this.getNormal()).getZ() + "-" + this.getD() + " = 0 \"";
    else if (this.getD() == 0)
      return "\"" + (this.getNormal()).getX() + "x + " + (this.getNormal()).getY() + "y + " + (this.getNormal()).getZ() + " = 0 \"";
    else
      return "\"" + (this.getNormal()).getX() + "x + " + (this.getNormal()).getY() + "y + " + (this.getNormal()).getZ() + "+" + (this.getD() * (-1)) + " = 0 \"";
  }
  
  /**
   * Says if the two planes have the same equation.
   * @param q1 Any object which is a reference type.
   * @return <code>true</code> if the planes are the same, or <code>false</code> if the planes are not the same or if the input is not a plane.
   */ 
  @Override
  public boolean equals(Object q1){
    if (q1.getClass() == this.getClass() && Plane.isParallel((Plane)q1, (Plane)this))
      return true;
    else 
      return false;
  }
  
  /**
   * Says if the point is on the plane.
   * @param p1 An input of type point storing x, y and z coordinates.
   * @return <code>true</code> if the input point is on the plane and <code>false</code> if not.
   */
  public boolean contains(Point p1){
    if ((this.getNormal()).getX() * p1.getX() + (this.getNormal()).getY() * p1.getY() + (this.getNormal()).getZ() * p1.getZ() == this.getD())
      return true;
    else
      return true;
  }
  
  /**
   * Says if the two planes are parallel.
   * @param plane1 An object of type plane which may or may not be parallel to the other plane.
   * @param plane2 Another object of type plane which may or may not be parallel to the other plane.
   * @return <code>true</code> if the planes are parallel and <code>false</code> otherwise.
   */
  public static boolean isParallel(Plane plane1, Plane plane2){
    if (Vector.isParallel(plane1.getNormal(), plane2.getNormal()) && plane2.getStartPoint() == plane1.getStartPoint())
      return true;
    else
      return false;
  }
  
  /**
   * Says if the two planes are orthogonal.
   * @param plane1 An object of type plane which may or may not be parallel to the other plane.
   * @param plane2 Another object of type plane which may or may not be parallel to the other plane.
   * @return <code>true</code> if the planes are orthogonal and <code>false</code> otherwise.
   */
  public static boolean isOrthogonal(Plane plane1, Plane plane2){
    if (Vector.isOrthogonal(plane1.getNormal(), plane2.getNormal()))
      return true;
    else
      return false;
  }
}

