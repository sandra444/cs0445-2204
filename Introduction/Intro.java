public class Intro {
  public static void main(String[] args){
    Measurable aSquare;
    //aSquare = new Measurable();//ILLEGAL
    aSquare = new Square<Double>(10.0);
    System.out.println("Area of the square is " +
                        aSquare.getArea());
  }

  private Measurable getMinimum(Measurable[] shapes){
    Measurable result = null;
    if(shapes.length > 0){
      result = shapes[0];

      for(int i=1; i<shapes.length; i++){
        if(shapes[i].compareTo(result) < 0){
          result = shapes[i];
        }
      }
    }
    return result;
  }
}
