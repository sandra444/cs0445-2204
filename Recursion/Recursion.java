public final class Recursion {
  public static void main(String[] args){
    countDown(10);
    displayArray(new Integer[]{9, 7, 5, 3, 1, 0});
    int n = 5;
    System.out.println(n + "! = " + factorial(n));
    n = 1;
    System.out.println(n + "! = " + factorial(n));
    int x=2;
    int y=8;
    System.out.println(x+"^"+y+" = " + power(x, y));
    x=2;
    y=9;
    System.out.println(x+"^"+y+" = " + power(x, y));
    n = 10;
    System.out.println("fib("+n+") = " + fib(n));
    displayArray2(new Integer[]{1, 6, 7, 10, 8, 9});
    System.out.println("----------------");
    displayArray2(new Integer[]{1, 13, 6, 7, 10});
    System.out.println("----------------");
    displayArray3(new Integer[]{1, 6, 7, 10, 8, 9});
    System.out.println("----------------");

    displayArray3(new Integer[]{1, 13, 6, 7, 10});
    towersOfHanoi(3, 0, 2, 1);
  }

  private static void countDown(int n){
    System.out.println(n);
    if(n > 1){
      countDown(n-1);
    }
  }

  public static <T> void displayArray(T[] array){
    displayHelper(array, 0);
  }

  private static <T> void displayHelper(T[] array,
  int start){
    if(start < 0 || start > array.length-1){
      throw new IndexOutOfBoundsException("Invalid index");
    }
    System.out.println(array[start]);
    if(start != array.length-1){
      displayHelper(array, start+1);
    }
  }

  public static int factorial(int n){
    if(n < 0){
      throw new IllegalArgumentException("Invalid value of n");
    }
    int result = 1;
    if(n > 0){//base case
      result = n * factorial(n-1);
    }
    return result;
  }

  public static int power(int x, int y){
    int result = 1;
    if(y > 0){
      int temp = power(x, y/2);
      result = temp * temp;
      if(y % 2 != 0){//y is even
        result = x * result;
      }
    }
    return result;
  }

  public static int fib(int n){
    int result = 0;
    if(n == 1){
      result = 1;
    } else if(n > 1) {
      result = fib(n-1) + fib(n-2);
    }
    return result;
  }

  public static <T> void displayArray2(T[] array){
    displayArrayHelper2(array, 0, array.length);
  }

  private static <T> void displayArrayHelper2(
  T[] array, int start, int length){
    if(length == 1){
      System.out.println(array[start]);
    } else {
      displayArrayHelper2(array, start, length/2);
      displayArrayHelper2(array, start + length/2,
      length/2);
      if(length % 2 == 1){
        System.out.println(array[start + length - 1]);
      }
    }
  }

  public static <T> void displayArray3(T[] array){
    displayArrayHelper3(array, 0, array.length-1);
  }

  private static <T> void displayArrayHelper3(
  T[] array, int start, int end){
    if(start == end){
      System.out.println(array[start]);
    } else {
      int mid = start + (end - start)/2;
      displayArrayHelper3(array, start, mid);
      displayArrayHelper3(array, mid+1, end);
    }
  }

  private static void towersOfHanoi(
        int nDisks, int start,
        int end, int aux){
        if(nDisks == 1){
          System.out.println(
            "Move one disk from Pole " +
            start + " to Pole " + end);
        } else {
          towersOfHanoi(nDisks-1,
                        start,
                        aux, end);
          System.out.println(
            "Move one disk from Pole " +
            start + " to Pole " + end);
          towersOfHanoi(nDisks-1,
                        aux,
                        end,
                        start);
        }
      }
}
