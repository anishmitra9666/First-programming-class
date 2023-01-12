/**
 * A line represented in three dimensions with x, y and z coordinates.
 * @author Anish Mitra(axm949)
 */ 
public class Line{
  
  // Storing the start point
  private Point point1;
  
  // Storing a vector
  private Vector vector;
  
  /** 
   * Creates a line in 3 dimensions with x, y and z coordinates.
   * @param point1 The first point the line is constructed from(also the start point).
   * @param point2 The second point the line is constructed from(also the end point).
   */
  public Line(Point point1, Point point2){
    super();
    this.point1 = point1;
  }
  
  /** 
   * Creates a line in 3 dimensions with x, y and z coordinates.
   * @param point1 The first point the line is constructed from(also the start point).
   * @param vector The direction the line is going in.
   */
  public Line(Point point1, Vector vector){
    super();
    this.point1 = point1;
    this.vector = vector;
  }
  
  /**
   * A helper method returning the starting point of the line.
   * @return The start point of the line.
   */ 
  public Point getStartPoint(){
    return point1;
  }
  
   /**
   * Returns a string representation of the line in 3 dimensions.
   * @return A string representation of the line in 3 dimensions.
   */ 
  @Override
  public String toString(){
    return "x = " + (this.getStartPoint()).getX() + " + t" + (this.getVector()).getX() + ",\n" + "y = " + (this.getStartPoint()).getY() + " + t" + (this.getVector()).getY() + ", \n" + "z = " + (this.getStartPoint()).getZ() + " + t" + (this.getVector()).getZ();
  }
  
  /**
   * Says if the two lines have teh same equations.
   * @param line1 Any object which is a reference type.
   * @return <code>true</code> if the lines are the same, or <code>false</code> if the lines are not the same or if the input is not a line in 2 dimensions.
   */ 
  @Override
  public boolean equals(Object line1){
    if (line1.getClass() == this.getClass()){
      if (((Line)line1).getStartPoint() == this.getStartPoint() && (((Line)line1).getVector()).unitVector() == (this.getVector()).unitVector())
        return true;
      else 
        return false;
    }
    else
      return false;
  }
  
  /**
   * Returns the vector used to construct the line.
   * @return A vector which represents the direction the line is going in.
   */ 
  public Vector getVector(){
    return vector;
  }
  
  /**
   * Returns if the lines are parallel or not.
   * @param line1 A line in 3 dimensions with x, y and z coordinates.
   * @param line2 A line in 3 dimensions with x, y and z coordinates.
   * @return <code>true</code> if the unit vectors are the same but the lines are not else returns <code>false</code>.
   */ 
  public static boolean isParallel(Line line1, Line line2){
    if ((line1.getVector()).unitVector() == (line2.getVector()).unitVector() && line1.equals(line2) == false)
      return true;
    else
      return false;
  }
  
  /**
   * Returns the point of intersection between the two lines.
   * @param line1 A line represented in 3 dimensions.
   * @param line2 A line represented in 3 dimensions.
   * @return Returns the point of intersection between the two lines such as <code>(2.0,3.0,4.0)</code>.
   */
  public static Point intersection(Line line1, Line line2){
    double t = ((((line2.getVector()).getY()/(line2.getVector()).getX()) * ((line2.getStartPoint()).getX() - (line1.getStartPoint()).getX()) - (line2.getStartPoint()).getY() - (line1.getStartPoint()).getY())/((((line2.getVector()).getY()) * ((line1.getVector()).getX()/(line2.getVector()).getX())) - (line1.getVector()).getY()));
    double s = (((t * (line1.getVector()).getX()) + (line1.getStartPoint()).getX() - (line2.getStartPoint()).getX())/(line2.getVector()).getX());
    if (Line.isParallel(line1, line2) == true || line1.equals(line2) == true)
      return null;
    else if ((((line1.getVector()).getZ() * t) + (line1.getStartPoint()).getZ()) != (((line2.getVector()).getZ() * s) + (line2.getStartPoint()).getZ()))
      return null;
    else{
      Point intersection = new Point((((line1.getVector()).getX() * t) + (line1.getStartPoint()).getX()), (((line1.getVector()).getY() * t) + (line1.getStartPoint()).getY()), (((line1.getVector()).getZ() * t) + (line1.getStartPoint()).getZ()));
      return intersection;
    } 
  }
}