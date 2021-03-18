public class MyDeque<E>{
  private E[] data;
  private int size, start, end; // start and end represent next spots

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 9;
    end = size = 0;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = initialCapacity-1;
    end = size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if (size == 0) return "{}";
    String str = "{";
    for (int i = start+1; i < data.length; i ++){
      str += data[i]+", ";
    }
    for (int i = 0; i < end; i ++){
      str += data[i]+", ";
    }
    return str.substring(0, str.length()-2)+"}";
  }

  public void addFirst(E element){
    size ++;
    data[start] = element;
    start --;
  }

  public void addLast(E element){
    size ++;
    data[end] = element;
    end ++;
  }

  public E removeFirst(){
    size --;
    E temp = data[start+1];
    data[start+1] = null;
    start ++;
    return temp;
  }

  public E removeLast(){
    size --;
    E temp = data[end-1];
    data[end-1] = null;
    end --;
    return temp;
  }

  public E getFirst(){
    if (start == data.length-1){
      return data[0];
    }
    return data[start+1];
  }

  public E getLast(){
    if (end == 0){
      return data[data.length-1];
    }
    return data[end-1];
  }
}
