public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){

  }

  public MyDeque(int initialCapacity){

  }

  public int size(){

  }

  public String toString(){

  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(){
    E temp = data[start];
    data[start] = null;
    return temp;
  }

  public E removeLast(){
    E temp = data[end];
    data[end] = null;
    return temp;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }
}
