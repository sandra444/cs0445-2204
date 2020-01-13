//Square<T> is a generic type
//T is a type parameter
//Square is a raw type
//Square<Integer> is a parameterized type
public class Square<T extends Number> implements Measurable {
  private T sideLength;

  // public Square(){ //Default constructor
  //   sideLength = Measurable.DEFAULT_DIMENSION;
  // }

  public Square(T sideLength){
    //sideLength = _sideLength;
    this.sideLength = sideLength;
  }
  /**
    * @return the area of the shape
  **/
  public Double getArea(){
    return sideLength.doubleValue()*sideLength.doubleValue();
  }
  /**
    * @return the perimeter of the shape
  **/
  public Double getPerimeter(){
    return 4*sideLength.doubleValue();
  }

  public int compareTo(Measurable other){
    // if(this.getArea() == other.getArea()){
    //   return 0;
    // } else if (this.getArea() < other.getArea()){
    //   return -1;
    // } else {
    //   return 1;
    // }
    return getArea().compareTo(other.getArea());

  }
  //Overriding
  public String toString(){
    return "This is a square of area " + getArea() +
           " and perimeter " + getPerimeter();
  }
}
