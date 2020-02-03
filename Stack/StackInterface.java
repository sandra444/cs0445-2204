public interface StackInterface<T>{

  public boolean push(T item);

  public T pop();

  public T top();
  
  public int size();

  public void clear();

  public boolean isEmpty();

  public boolean isFull();
}
