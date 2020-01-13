public class ColoredSquare<T extends Number> extends Square<T>{

  private String color;

  public ColoredSquare(T sideLength){
    //ILLEGAL because sideLength is private
    //this.sideLength = sideLength;
    super(sideLength);
    this.color = "Blue";
  }

  public ColoredSquare(T sideLength, String color){
    super(sideLength);
    this.color = color;
  }

  public String toString(){
    return super.toString() + " and a " + color + " color";
  }

}
