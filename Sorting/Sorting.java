import java.util.Arrays;

public class Sorting {
  public static void main(String[] args){
    new Sorting();
  }

  public Sorting(){
    Integer[] array = new Integer[]{20, 10, 0, 30, 15, 1, 2, 90, 9, 35, -1, 3};
        //selectionSort(array);
        //insertionSort(array);
        //ShellSort(array);
        //recursiveInsertionSort(array, 0, array.length-1);
        //recursiveSelectionSort(array, 0, array.length-1);
        //recursiveSelectionSort2(array, 0, array.length-1);
        //System.out.println(Arrays.toString(array));

        Node<Integer> firstNode = createChain(array);
        firstNode = chainInsertionSort(firstNode);
        printChain(firstNode);
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

  private <T extends Comparable<? super T>>
     int findLargestIndex(T[] a, int first, int last){
    T largest = a[first];
    int largestIndex = first;
    for(int i=first+1; i<=last; i++){
      if(a[i].compareTo(largest)>0){
        largest = a[i];
        largestIndex = i;
      }
    }
    return largestIndex;
  }

  private <T> void swap(T[] a, int first, int second){
    T temp = a[first];
    a[first] = a[second];
    a[second] = temp;
  }

  private <T extends Comparable<? super T>>
    void recursiveSelectionSort(T[] a, int first, int last){
      if(last-first > 0){
        int smallestIndex = findSmallestIndex(a, first, last);
        swap(a, first, smallestIndex);
        recursiveSelectionSort(a, first+1, last);
      }
    }

    private <T extends Comparable<? super T>>
      void recursiveSelectionSort2(T[] a, int first, int last){
        if(last-first > 0){
          int largestIndex = findLargestIndex(a, first, last);
          swap(a, last, largestIndex);
          recursiveSelectionSort2(a, first, last-1);
        }
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

  private <T extends Comparable<? super T>>
    void recursiveInsertionSort(T[] a, int first, int last){
      if(last-first > 0){
        recursiveInsertionSort(a, first, last-1);
        insertInOrder(a, a[last], first, last-1);
      }
    }

    private <T extends Comparable<? super T>>
      Node<T> chainInsertInOrder(Node<T> firstNode, Node<T> item){
        if(item.data.compareTo(firstNode.data) <= 0){
          item.next = firstNode;
          firstNode = item;
        } else {
          Node<T> current = firstNode;
          while(current != null &&
                current.next != null &&
                current.next.data.compareTo(item.data)<0){
            current = current.next;
          }
          item.next = current.next;
          current.next = item;
        }
        return firstNode;
      }

    private <T extends Comparable<? super T>>
      Node<T> chainInsertionSort(Node<T> firstNode){
        Node<T> unsorted = firstNode.next;
        firstNode.next = null;
        Node<T> current = unsorted;
        while(current != null){
          Node<T> next = current.next;
          firstNode = chainInsertInOrder(firstNode, current);
          current = next;
        }
        return firstNode;
      }

    private <T> void printChain(Node<T> firstNode){
      Node<T> current = firstNode;
      while(current != null){
        System.out.print(current.data + " ");
        current = current.next;
      }
      System.out.println();
    }

    private <T> Node<T> createChain(T[] array){
      Node<T> firstNode = new Node<>(array[array.length-1]);
      for(int i=array.length-2; i>=0; i--){
        firstNode = new Node<T>(array[i], firstNode);
      }
      return firstNode;
    }

    private class Node<T>{
      T data;
      Node<T> next;

      private Node(T data){
        this(data, null);
      }
      private Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
      }
    }


}
