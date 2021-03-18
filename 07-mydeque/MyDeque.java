public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    end = 9;
    start = size = 0;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    end = initialCapacity-1;
    start = size = 0;
  }

  public int size(){
    return size;
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
