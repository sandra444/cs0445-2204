public class BinaryNode<T> {
  private T data;
  private BinaryNode<T> left;
  private BinaryNode<T> right;

  public BinaryNode(T data){
    this(data, null, null);
  }

  public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public T getData(){
    return data;
  }

  public void setData(T data){
    this.data = data;
  }

  public BinaryNode<T> getLeftChild(){
    return left;
  }

  public void setLeftChild(BinaryNode<T> left){
    this.left = left;
  }

  public BinaryNode<T> getRightChild(){
    return right;
  }

  public void setRightChild(BinaryNode<T> right){
    this.right = right;
  }

  public boolean hasLeftChild(){
    return left != null;
  }

  public boolean hasRightChild(){
    return right != null;
  }

  public boolean isLeaf(){
    return left == null && right == null;
  }

  public int getNumberOfNodes(){
    int result = 1;
    if(left != null){
      result += left.getNumberOfNodes();
    }
    if(right != null){
      result += right.getNumberOfNodes();
    }
    return result;
  }

  public int getHeight(){
    int result = 1;
    int leftHeight = 0;
    int rightHeight = 0;

    if(left != null){
      leftHeight = left.getHeight();
    }
    if(right != null){
      rightHeight = right.getHeight();
    }
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public BinaryNode<T> copy(){
    BinaryNode<T> copy = new BinaryNode<>(data);
    if(left != null){
      copy.setLeftChild(left.copy());
    }
    if(right != null){
      copy.setRightChild(right.copy());
    }
    return copy;
  }


}
