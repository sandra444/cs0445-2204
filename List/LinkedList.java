public final class LinkedList<T> implements ListInterface<T>{
    private Node firstNode;
    private int size;

    public boolean add(T item, int position){
      Node prev = referenceTo(position-1);
      prev.next = new Node(item, prev.next);
      size++;
      return true;
    }

    public T remove(int position){
      return null;
    }

    public T itemAt(int position){
      return null;
    }

    private Node referenceTo(int position){
      Node result = null;
      Node current = firstNode;
      int index = 0;
      while(current != null && index < position){
        index++;
        current = current.next;
      }
      result = current;
      return result;
    }
    private class Node {
      private T data;
      private Node next;

      private Node(T data){
        this(data, null);
      }

      private Node(T data, Node next){
        this.data =  data;
        this.next = next;
      }
    }
}
