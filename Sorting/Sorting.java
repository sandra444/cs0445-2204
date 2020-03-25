import java.util.Arrays;

public class Sorting {
  public static void main(String[] args){
    new Sorting();
  }

  public Sorting(){
    Integer[] array = new Integer[]{20, 10, 0, 30, 15, 1, 2, 90, 9, 35, -1, 3};
        //selectionSort(array);
        //insertionSort(array);
        ShellSort(array);
        System.out.println(Arrays.toString(array));
  }

  public <T extends Comparable<? super T>>
     void selectionSort(T[] a){
       selectionSort(a, 0, a.length-1);
  }

  private <T extends Comparable<? super T>>
     void selectionSort(T[] a, int first, int last){
       for(int i=first; i<last; i++){
         int smallestIndex = findSmallestIndex(a, i, last);
         swap(a, smallestIndex, i);
       }
  }

  private <T extends Comparable<? super T>>
     int findSmallestIndex(T[] a, int first, int last){
    T smallest = a[first];
    int smallestIndex = first;
    for(int i=first+1; i<=last; i++){
      if(a[i].compareTo(smallest)<0){
        smallest = a[i];
        smallestIndex = i;
      }
    }
    return smallestIndex;
  }

  private <T> void swap(T[] a, int first, int second){
    T temp = a[first];
    a[first] = a[second];
    a[second] = temp;
  }

  public <T extends Comparable<? super T>>
    void insertionSort(T[] a){
      insertionSort(a, 0, a.length-1);
  }

  private <T extends Comparable<? super T>>
    void insertionSort(T[] a, int first, int last){
        for(int unprocessed=first+1; unprocessed<= last; unprocessed++){
          insertInOrder(a, a[unprocessed], first, unprocessed-1);
        }
  }

  private <T extends Comparable<? super T>>
      void insertInOrder(T[] a, T item, int begin, int end){
        int index = end;
        while(index >= begin && a[index].compareTo(item)>0){
          a[index+1] = a[index];
          index--;
        }
        a[index+1] = item;
  }

  public <T extends Comparable<? super T>>
    void ShellSort(T[] a){
      ShellSort(a, 0, a.length-1);
  }

  private <T extends Comparable<? super T>>
    void ShellSort(T[] a, int first, int last){
      int n = last-first+1;
      for(int space=n/2; space>0; space= space/2){
        if(space%2 == 0){
          space++;
        }
        for(int i=0; i<space; i++){
          incrementalInsertionSort(a, first+i, last, space);
        }
      }

  }

  private <T extends Comparable<? super T>>
    void incrementalInsertionSort(T[] a, int first, int last, int space){
        for(int unprocessed=first+space; unprocessed<= last; unprocessed+=space){
          incrementalInsertInOrder(a, a[unprocessed], first, unprocessed-space, space);
        }
  }

  private <T extends Comparable<? super T>>
      void incrementalInsertInOrder(T[] a, T item, int begin, int end, int space){
        int index = end;
        while(index >= begin && a[index].compareTo(item)>0){
          a[index+space] = a[index];
          index-=space;
        }
        a[index+space] = item;
  }
}
