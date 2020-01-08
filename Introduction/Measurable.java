/**
  * An interface for shapes that have an area
  * and a permiter.
**/
public interface Measurable extends Comparable<Measurable> {

//public final static double DEFAULT_DIMENSION = 10;
/**
  * @return the area of the shape
**/
  public Double getArea();
/**
  * @return the perimeter of the shape
**/
  public Double getPerimeter();

}
