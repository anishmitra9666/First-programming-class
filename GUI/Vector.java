/**
 * A vector is basically a line segment with both magnitudde and direction.
 * @author Anish Mitra(axm949)
 */ 
public class Vector{
  
  // The x-coordinate
  private double xVector;
  
  // The y-coordinate
  private double yVector;
  
  // The z-coordinate
  private double zVector;
  
  /**
   * Creates a vector going in the direction from the origin to the x,y and z coordinates and the magnitude is simply the length from the origin to those coordinates.
   * @param xVector the x-coordinate of the vector of type double.
   * @param yVector the y-coordinate of the vector of type double.
   * @param zVector the z-coordinate of the vector of type double. 
   */ 
  public Vector(double xVector, double yVector, double zVector){
    super();
    this.xVector = xVector;
    this.yVector = yVector;
    this.zVector = zVector;
  }
  
  /**
   * Creates a vector in the same way as the constructor above except that the coordinates are represented in a Point variable.
   * @param vectorPoint A value of type point with three doubles stored in it representing x, y and z coordinates.
   */ 
  public Vector(Point vectorPoint){
    super();
    this.xVector = vectorPoint.getX();
    this.yVector = vectorPoint.getY();
    this.zVector = vectorPoint.getZ();
  }
  
  /**
   * Creates a vector of length vectorlength in the direction of the vector v2.
   * @param vectorlength A double which represents the length of the vector.
   * @param v2 A vector which is parallel to the vector created.
   */ 
  public Vector(Vector v2, double vectorlength){
    super();
    this.xVector = (v2.getX() * vectorlength);
    this.yVector = (v2.getY() * vectorlength);
    this.zVector = (v2.getZ() * vectorlength);
  }
  
  /**
   * Returns the x-coordinate of the vector
   * @return The x-coordinate <code>x</code>.
   */
  public double getX(){
    return xVector;
  }
  
  /**
   * Returns the y-coordinate of the vector
   * @return The y-coordinate <code>y</code>.
   */
  public double getY(){
    return yVector;
  }
  
  /**
   * Returns the z-coordinate of the vector
   * @return The z-coordinate <code>z</code>.
   */
  public double getZ(){
    return zVector;
  }
  
  /**
   * Returns a string representation of the vector.
   * @return A string representation of the vector such as 2.0, 3.0, 4.0.
   */ 
  @Override
  public String toString(){
    return "<" + this.getX()  +  ","  +  this.getY() +  ","  +  this.getZ() + ">";
  }
  
  /**
   * Says if the two vectors have the same coordinates.
   * @param p1 Any object which is a reference type.
   * @return <code>true</code> if the vectors are the same, or <code>false</code> if the vectors are not the same or if the input is not a vector.
   */ 
  @Override
  public boolean equals(Object p1){
    if (p1.getClass() == this.getClass() && ((Vector)p1).getY() == this.getY() && ((Vector)p1).getX() == this.getX() && ((Vector)p1).getZ() == this.getZ())
      return true;
    else 
      return false;
  }
  
  /**
   * Returns the magnitude of the vector.
   * @return The magnitude of the vector <code>v1</code> as a double.
   */
  public double magnitude(){
    return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
  }
  
  /**
   * Returns the original vector with its coordinates divided by its magnitude.
   * @return The vector divided by its magnitude.
   */ 
  public Vector unitVector(){
    Vector unitVector = new Vector(this.getX()/this.magnitude(), this.getY()/this.magnitude(), this.getZ()/this.magnitude());
    return unitVector;
  }
  
  /**
   * Returns the sum of the two vectors inputed by adding up the x, y and z coordinates.
   * @param v1 An object which is of type vecctor
   * @param v2 A different vector object
   * @return The vector divided by its magnitude.
   */
  public static Vector sum(Vector v1, Vector v2){
    Vector vectorSum = new Vector((v1.getX() + v2.getX()), (v1.getY() + v2.getY()), (v1.getZ() + v2.getZ()));
    return vectorSum;
  }
  
  /**
   * Returns a vector where each coordinate is multiplied by a constant scale factor.
   * @param v1 An object which is of type vector.
   * @param scale A double which is the scale factor.
   * @return Each coordinate multipled by a scale factor to return the vector.
   */ 
  public static Vector scale(Vector v1, double scale){
    Vector vectorScale = new Vector((v1.getX() * scale), (v1.getY() * scale), (v1.getZ() * scale));
    return vectorScale;
  }
  
  /**
   * Returns a double which is the dotProduct.
   * @param v1 A parameter of type vector.
   * @param v2 A parameter of type vector.
   * @return Each vector's coordinate multipled by the other vector's corresponding coordinate and then added together.
   */ 
  public static double dotProduct(Vector v1, Vector v2){
    return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
  }
  
  /**
   * Returns a vector which calculates the crossProduct of the two vectors.
   * @param v1 A parameter of type vector.
   * @param v2 A parameter of type vector.
   * @return Each vector's y-coordinate times the other vector's z-coordinate minus the z-coordinate of the first vector times the y-coordinate of the second to determine the x-coordinate. A similar process is used to find the y and z coordiantes and these coordinates are then represented in vector form. 
   */ 
  public static Vector crossProduct(Vector v1, Vector v2){
    Vector crossProduct = new Vector(((v1.getY() * v2.getZ())) - (v1.getZ() * v2.getY()), (((v1.getX() * v2.getZ())) - (v1.getZ() * v2.getX())) * (-1), ((v1.getX() * v2.getY())) - (v1.getY() * v2.getX()));
    return crossProduct;
  }
  
  /**
   * Returns the angle between the two vectors.
   * @param v1 A parameter of type vector.
   * @param v2 A parameter of type vector.
   * @return The angle between the two vectors <code>v1</code> and <code>v2</code>
   */ 
  public static double angle(Vector v1, Vector v2){
    return Math.acos((dotProduct(v1, v2))/(v1.magnitude() * v2.magnitude()));
  }
  
  /**
   * Returns if the vectors are orthogonal.
   * @param v1 A parameter of type vector.
   * @param v2 A parameter of type vector.
   * @return Returns <code>true</code> if the dot product between the vectors is zero and <code>false</code> otherwise.
   */ 
  public static boolean isOrthogonal(Vector v1, Vector v2){
    if (dotProduct(v1, v2) == 0)
      return true;
    else
      return false;
  }
  
  
  /**
   * Returns if the vectors are parallel.
   * @param v1 A parameter of type vector.
   * @param v2 A parameter of type vector.
   * @return Returns <code>true</code> if the dot product between the vectors is zero and <code>false</code> otherwise.
   */
  public static boolean isParallel(Vector v1, Vector v2){
    if ((Vector.crossProduct(v1,v2)).magnitude() == 0)
      return true;
    else
      return false;
  }
}
