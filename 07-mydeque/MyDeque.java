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
    size ++;
    if (start == 0){
      data[data.length-1] = element;
      start = data.length-1;
    }else{
      data[start-1] = element;
      start --;
    }
  }

  public void addLast(E element){
    size ++;
    if (end == data.length-1){
      data[0] = element;
      end = 0;
    }else{
      data[end+1] = element;
      end ++;
    }
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
