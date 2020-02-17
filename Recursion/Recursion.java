public final class Recursion {
  public static void main(String[] args){
    countDown(10);
    displayArray(new Integer[]{9, 7, 5, 3, 1, 0});
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
}
