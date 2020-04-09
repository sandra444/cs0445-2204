import java.util.Arrays;

public class Sorting {
  private static final int MIN_SIZE = 2;
  public static void main(String[] args){
    new Sorting();
  }

  public Sorting(){
        Integer[] array = new Integer[]{20, 10, 0, 30, 15, 1, 2, 90, 9, 35, -1, 3, 15, -4, 3, 6};
        //selectionSort(array);
        //insertionSort(array);
        //ShellSort(array);
        //recursiveInsertionSort(array, 0, array.length-1);
        //recursiveSelectionSort(array, 0, array.length-1);
        //recursiveSelectionSort2(array, 0, array.length-1);
        //mergeSort(array);
        //quickSort(array);
        quickSort2(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

        // Node<Integer> firstNode = createChain(array);
        // firstNode = chainInsertionSort(firstNode);
        // printChain(firstNode);
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
      if(a[i].compareTo(smallest)<0){ //(<=) makes it unstable
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
      if(a[i].compareTo(largest)>=0){ //(>) makes it unstable
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
        while(index >= begin && a[index].compareTo(item)>0){ //(>=) makes it unstable
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
        recursiveInsertInOrder(a, a[last], first, last-1);
      }
    }

  private <T extends Comparable<? super T>>
    void recursiveInsertInOrder(T[] a, T item, int begin, int end){
      if(a[end].compareTo(item) <= 0){
        a[end+1] = item;
      } else if(begin == end){
        a[end+1] = a[end];
        a[end] = item;
      } else {
        a[end+1] = a[end];
        a[end] = item;
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

   public <T extends Comparable<? super T>>
      void mergeSort(T[] a){
        @SuppressWarnings("unchecked")
        T[] output = (T[])new Comparable<?>[a.length];
        mergeSort(a, 0, a.length-1, output);
      }


  private <T extends Comparable<? super T>>
    void mergeSort(T[] a, int first, int last, T[] output){
      if(last - first > 0){
      //int mid = (first + last)/2; <= may cause an overflow
        int mid = first + (last-first)/2;
        mergeSort(a, first, mid, output);
        mergeSort(a, mid+1, last, output);
        if(a[mid].compareTo(a[mid+1]) > 0) //adaptive
          merge(a, first, mid, last, output);
      }
    }

  private <T extends Comparable<? super T>>
    void merge(T[] a, int first, int mid, int last, T[] output){
      // @SuppressWarnings("unchecked")
      // T[] output = (T[])new Comparable<?>[last-first+1];

      int i = first;
      int j = mid+1;
      int k = first;
      while(i <= mid && j <= last){
        if(a[i].compareTo(a[j]) <= 0){ // (<) makes the algorithm not stable
          output[k] = a[i];
          i++;
        } else {
          output[k] = a[j];
          j++;
        }
        k++;
      }
      while(i <= mid){
        output[k] = a[i];
        i++;
        k++;
      }
      while(j <= last){
        output[k] = a[j];
        j++;
        k++;
      }
      for(int index=first; index<=last; index++){
        a[index] = output[index];
      }
    }

    public <T extends Comparable<? super T>>
      void quickSort(T[] a){
        quickSort(a, 0, a.length-1);
      }

    private <T extends Comparable<? super T>>
      void quickSort(T[] a, int first, int last){
        if(last - first + 1 > MIN_SIZE){
          int pivotIndex = partition(a, first, last);
          quickSort(a, first, pivotIndex-1);
          quickSort(a, pivotIndex+1, last);
        } else {
          insertionSort(a, first, last);
        }
      }

      private <T extends Comparable<? super T>>
        void quickSort2(T[] a, int first, int last){
          while(last - first + 1 > MIN_SIZE){
            int pivotIndex = partition(a, first, last);
            if((pivotIndex-1 - first + 1) <= (last - (pivotIndex+1) + 1)){
              quickSort(a, first, pivotIndex-1);
              //quickSort(a, pivotIndex+1, last);
              //parameter = argument
              //a = a;
              first = pivotIndex+1;
              //last = last;
            } else {
              quickSort(a, pivotIndex+1, last);
              // quickSort(a, first, pivotIndex-1);
              // a = a;
              // first = first;
              last = pivotIndex - 1;
            }
          }
          insertionSort(a, first, last);

        }

      private <T extends Comparable<? super T>>
        int partition(T[] a, int first, int last){
          int mid = first + (last - first)/2;
          SortThreeElements(a, first, mid, last);
          swap(a, mid, last-1);
          int pivotIndex = last-1;
          T pivotValue = a[pivotIndex];

          int i = first + 1;
          int j = last - 2;

          boolean done = false;

          while(!done){
            while(a[i].compareTo(pivotValue)<0){
              i++;
            }

            while(a[j].compareTo(pivotValue)>0){
              j--;
            }

            if(i > j){
              done = true;
            } else{
              swap(a, i, j);
              i++;
              j--;
            }
          }

          swap(a, last-1, i);
          pivotIndex = i;
          return pivotIndex;
        }

        private <T extends Comparable<? super T>>
          void SortThreeElements(T[] a, int first, int mid, int last){
            if(a[first].compareTo(a[mid]) > 0){
              swap(a, first, mid);
            }
            if(a[mid].compareTo(a[last]) > 0){
              swap(a, mid, last);
            }
            if(a[first].compareTo(a[mid]) > 0){
              swap(a, first, mid);
            }
          }

}
