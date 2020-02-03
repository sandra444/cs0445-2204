public final class ArrayStack<T>
implements StackInterface<T>{
  private static final int DEFAULT_CAPACITY = 10;
  private static final int MAX_CAPACITY = 1000;
  private final T[] stack;
  private int topIndex;
  private boolean initialized;

  public ArrayStack(){
    this(DEFAULT_CAPACITY);
  }
  public ArrayStack(int capacity){
    checkCapacity(capacity);
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[capacity];
    stack = temp;
    topIndex = 0;
    initialized = true;
  }

  public boolean push(T item){
    boolean result = false;
    if(!isFull()){
      stack[topIndex] = item;
      topIndex++;
      result = true;
    }
    return result;
  }

  public T pop(){
    T result = null;
    if(!isEmpty()){
      result = stack[topIndex-1];
      stack[topIndex-1] = null;
      topIndex--;
    }
    return result;
  }

  public T top(){
    // result = stack[topIndex-1];
    // return result;
    return stack[topIndex-1];
  }

  public int size(){
    return topIndex;
  }

  public void clear(){
    while(!isEmpty()){
      pop();
    }
    /*
    for(int i=0; i<size(); i++){
      pop();
    } <= BUGGY!!
    */
  }

  public boolean isEmpty(){
    //return size() == 0;
    return topIndex == 0;
  }

  public boolean isFull(){
    return topIndex == stack.length;
  }

  private void checkCapacity(int capacity){
    if(capacity <= 0 || capacity > MAX_CAPACITY){
      throw new IllegalStateException("Attempting to create an ArrayStack with an invalid capacity.");
    }
  }

  private void checkIntegrity(){
    if(!initialized){
      throw new SecurityException("Attempting to access an uninitialized ArrayStack");
    }
  }

}
