public class ArrayBag<T> implements BagInterface<T>{

  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 1000;
  private T[] bag;
  private int size;
  private boolean initialized;

  public ArrayBag(){
    this(DEFAULT_CAPACITY);
  }

  public ArrayBag(int initialCapacity){
    checkCapacity(initialCapacity);
    int size = 0;
    @SuppressWarnings("unchecked")
    T[] temp = (T[])new Object[initialCapacity];
    bag = temp;
    initialized = true;
  }
  /** Adds item to the bag.
   *  @return true if the insertion was successful
   *          and false otherwise.
   */
  public boolean add(T item){
    checkIntegrity();
    boolean result = false;
    if(size < bag.length){
      bag[size] = item;
      size++;
    }
    return result;
  }

  /** Removes an arbitrary instance of item from the bag
   * @param item is the item to be removed
   * @return the item that was removed.
   *         or null if item is not in the bag
   **/
  public T remove(T item){
    checkIntegrity();
    T result = null;
    int index = indexOf(item);
    if(index != -1){
      result = bag[index];
      bag[index] = bag[size-1];
      bag[size-1] = null;
      size--;
    }
    return result;
  }

  public T remove(){
    checkIntegrity();
    T result = null;
    if(!isEmpty()){
      result = bag[size-1];
      bag[size-1] = null;
      size--;
    }
    return result;
  }

  public boolean contains(T item){
    checkIntegrity();

    return indexOf(item) != -1;
  }

  public int getFrequencyOf(T item){
    checkIntegrity();
    int result = 0;
    for(int i=0; i<size; i++){
      if(bag[i].equals(item)){
        result++;
      }
    }
    return result;
  }

  public T[] toArray(){
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[size];
    for(int i=0; i<size; i++){
      result[i] = bag[i];
    }
    return result;
    //return bag; <= VERY INSECURE!
  }

  public boolean isEmpty(){
    return (size == 0);
  }

  public boolean isFull(){
    return (size == bag.length);
  }

  public int size(){
    return size;
  }

  public void clear(){
    // for(int i=0; i<size; i++){
    //   bag[i] = null;
    // }
    // size = 0;
    while(!isEmpty()){
      remove();
    }
    //bag = null; <= DON'T DO THAT
  }

  private void checkCapacity(int capacity){
    if(capacity < 0 || capacity > MAX_CAPACITY){
      throw new IllegalStateException("Attempting to intialize an ArrayBag with an incorrect capacity.");
    }
  }

  private void checkIntegrity(){
    if(!initialized){
      throw new SecurityException("Attempting to operate on an uninitialized ArrayBag.");
    }
  }

  private int indexOf(T item){
    int result = -1;
    for(int i=0; i<size; i++){
      if(bag[i].equals(item)){
        result = i;
        break;
      }
    }
    return result;
  }

}
