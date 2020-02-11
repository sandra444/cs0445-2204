public final class ArrayList<T> implements ListInterface<T> {
  private final T[] list;
  private int size;
  private boolean initialized;
  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 1000;

  public ArrayList(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayList(int capacity){
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[capacity];
    list = temp;
    size=0;
    initialized=true;
  }
  public boolean add(T item, int position){
    return false;
  }

  public T remove(int position){
    return null;
  }

  public T itemAt(int position){
    return null;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  private void makeSpace(int position){
    for(int i = size-1; i>= position; i--){
      list[i+1] = list[i];
    }
  }

}
