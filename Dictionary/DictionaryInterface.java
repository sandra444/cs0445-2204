public interface DictionaryInterface<T>{

  public T getItem(T item);

  public boolean contains(T item);

  public T addItem(T item);

  public T removeItem(T item);
}
