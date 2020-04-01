public final class LinkedList<T> implements ListInterface<T>{
    private Node firstNode;
    private int size;

    public boolean add(T item, int position){
      checkPositionForAdd(position);
      if(position == 0){
        firstNode = new Node(item, firstNode);
      } else {
        Node prev = referenceTo(position-1);
        prev.next = new Node(item, prev.next);
      }
      size++;
      return true;
    }

    public T remove(int position){
      checkPosition(position);
      T result = null;
      if(position == 0){
        firstNode = firstNode.next;
      } else{
        Node prev = referenceTo(position-1);
        Node at = prev.next;
        result = at.data;
        prev.next = at.next;
      }
      size--;
      return result;
    }

    public T itemAt(int position){
      checkPosition(position);
      return referenceTo(position).data;
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

    private void checkPositionForAdd(int position){
      if(position < 0 || position > size){
        throw new IndexOutOfBoundsException("Invalid position");
      }
    }

    private void checkPosition(int position){
      if(position < 0 || position > size-1){
        throw new IndexOutOfBoundsException("Invalid position");
      }
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
