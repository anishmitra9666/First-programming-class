/**
 * A line represented in two dimensions with only x and y coordinates.
 * @author Anish Mitra(axm949)
 */ 
public class Line2D extends Line{
  
  // Storing a start point
  private Point2D point12D;
  
  // Storing an end point
  private Point2D point22D;
 
  /** 
   * Creates a line in 2 dimensions with x and y coordinates.
   * @param point12D The first point the line is constructed from(also the start point).
   * @param point22D The second point the line is constructed from(also the end point).
   */
  public Line2D(Point2D point12D, Point2D point22D){
    super(point12D, point22D);
    this.point12D = point12D;
    this.point22D = point22D;
  }
  
  /**
   * A helper method which returns the start point.
   * @return A 2D point with x and y coordinates such as (2.0,3.0).
   */ 
  public Point2D getStartPoint(){
    return point12D;
  }
  
  /**
   * A helper method to get the slope of the line.
   * @return The slope of the line in the return type double.
   */
  public double getM(){
    return (point12D.getY() - point22D.getY())/(point12D.getX() - point22D.getX());
  }
  
  /**
   * A helper method to get the intercept of the line.
   * @return The intercept of the line in the return type double.
   */
  public double getC(){
    return (point22D.getY() - (this.getM() * point22D.getX()));
  }
  
  /**
   * Returns a string representation of the line in 2 dimensions.
   * @return A string representation of the line in 2 dimensions such as <code>y = 2x + 3</code> or <code>y = 3</code>.
   */ 
  @Override
  public String toString(){
    if (point12D.getY() == point22D.getY())
      return "y = " + point12D.getY();
    if (point12D.getX() == point22D.getX())
      return "x = " + point12D.getX();
    else
      return "y = " + this.getM() + "x " + this.getC();
  }
  
  /**
   * Says if the two lines have the same equations.
   * @param line1 Any object which is a reference type.
   * @return <code>true</code> if the lines are the same, or <code>false</code> if the lines are not the same or if the input is not a line in 2 dimensions.
   */ 
  @Override
  public boolean equals(Object line1){
    if (line1.getClass() == this.getClass()){
      if (((Line2D)line1).getM() == this.getM() && ((Line2D)line1).getC() == this.getC())
        return true;
      else 
        return false;
    }
    else
      return false;
  }
  
  /**
   * Returns if the lines are parallel or not.
   * @param line1 A line in 2 dimensions with x and y coordinates.
   * @param line2 A line in 2 dimensions with x and y coordinates.
   * @return <code>true</code> if the lines are parallel but otherwise <code>false</code>.
   */ 
  public static boolean isParallel(Line2D line1, Line2D line2){
    if (line1.getM() == line2.getM() && line1.equals(line2) == false)
      return true;
    else
      return false;
  }
  
  /**
   * Returns the point of intersection between the two lines.
   * @param line1 A line represented in 2 dimensions.
   * @param line2 A line represented in 2 dimensions.
   * @return Returns the point of intersection between the two lines such as <code>(2.0,3.0)</code>.
   */
  public static Point2D intersection(Line2D line1, Line2D line2){
    if (Line2D.isParallel(line1, line2) == false && line1.equals(line2) == false){
      Point2D intersection = new Point2D(((line1.getC() - line2.getC())/(line2.getM() - line1.getM())), (((line1.getC() - line2.getC())/(line2.getM() - line1.getM())) * line1.getM() + line1.getC()));
      return intersection;
    }
    else
      return null;
  }
}