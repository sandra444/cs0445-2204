public class ArrayBag<T> implements Bag<T>{

  private static final int DEFAULT_SIZE = 10;
  private T[] bag;
  private int size;

  public ArrayBag(){
    int size = DEFAULT_SIZE;
    @SuppressWarnings("unchecked")
    T[] temp = (T[])new Object[size];
    bag = temp;

  }

  public ArrayBag(int initialSize){

  }
  /** Adds item to the bag.
   *  @return true if the insertion was successful
   *          and false otherwise.
   */
  public boolean add(T item){
    return false;
  }

  /** Removes an arbitrary instance of item from the bag
   * @param item is the item to be removed
   * @return the item that was removed.
   *         or null if item is not in the bag
   **/
  public T remove(T item){
    return null;
  }

  public boolean contains(T item){
    return false;
  }

  public int getFrequencyOf(T item){
    return 0;
  }

  public T[] toArray(){
    return null;
  }

  public boolean isEmpty(){
    return false;
  }

  public boolean isFull(){
    return false;
  }

  public int size(){
    return 0;
  }

}
