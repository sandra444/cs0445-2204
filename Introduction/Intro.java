public class Intro {
  public static void main(String[] args){
    Square<Double> aSquare, anotherSquare;
    //aSquare = new Measurable();//ILLEGAL
    aSquare = new Square<Double>(10.0);
    anotherSquare = new Square<Double>(5.0);
    System.out.println("Area of the square is " +
                        aSquare.getArea());
    //ILLEGAL=> shapes = new Square<>[3];//2

    @SuppressWarnings("unchecked")
    //The array is initialized with nulls and null is
    //a legal value for Square<Double> objects
    Square<Double>[] shapes = (Square<Double>[])new Square<?>[3];
    shapes[0] = aSquare;//3
    shapes[1] = anotherSquare;//4
    shapes[2] = new ColoredSquare<Double>(2.0, "Green");
    Measurable minShape = getMinimum(shapes);
    System.out.println(minShape);
  }

  private static <T extends Comparable<T>> T getMinimum(T[] items){
    T result = null;
    if(items.length > 0){
      result = items[0];

      for(int i=1; i<items.length; i++){
        if(items[i].compareTo(result) < 0){
          result = items[i];
        }
      }
    }
    return result;
  }
}
