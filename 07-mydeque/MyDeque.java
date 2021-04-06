public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[50];
    data = d;
    start = size = 0;
    end = 49;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = size = 0;
    end = initialCapacity-1;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if (size == 0) return "{}";
    String str = "{";
    for (int i = start; i < data.length; i ++){
      str += data[i]+", ";
    }
    for (int i = 0; i <= end; i ++){
      str += data[i]+", ";
    }
    return str.substring(0, str.length()-2)+"}";
  }

  public void addFirst(E element){
    expand();
    if (start == 0){
      start = data.length-1;
    }else{
      start --;
    }
    data[start] = element;
    size ++;
  }

  public void addLast(E element){
    expand();
    if (end == data.length-1){
      end = 0;
    }else{
      end ++;
    }
    data[end] = element;
    size ++;
  }

  public void expand(){
    if (size == data.length){
      @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[1+data.length*2];
      for (int i = 0; i <= end; i ++){
        d[i] = data[i];
      }
      for (int i = start; i < data.length; i ++){
        d[d.length-data.length+i] = data[i];
      }
      if (end == data.length-1) end = d.length-1;
      if (start != 0) start = d.length-data.length+start;
      data = d;
    }
  }

  public E removeFirst(){
    E temp = data[start];
    data[start] = null;
    if (start == data.length-1){
      start = 0;
    }else{
      start ++;
    }
    size --;
    return temp;
  }

  public E removeLast(){
    E temp = data[end];
    data[end] = null;
    if (end == 0){
      end = data.length-1;
    }else{
      end --;
    }
    size --;
    return temp;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }
}
