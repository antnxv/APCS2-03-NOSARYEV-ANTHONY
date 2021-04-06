import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[50];
    data = d;
    start = 1;
    end = size = 0;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[]) new Object[initialCapacity];
    data = d;
    start = 1;
    end = size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    if (size == 0) return "{}";
    String str = "{";
    if (start <= end){
      for (int i = start; i <= end; i ++){
        str += data[i]+", ";
      }
    }else{
      for (int i = start; i <= end+data.length; i ++){
        if (i < data.length){
          str += data[i]+", ";
        }else{
          str += data[i-data.length]+", ";
        }
      }
    }
    return str.substring(0, str.length()-2)+"}";
  }

  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException("This deque does not permit null elements");
    }
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
    if (element == null){
      throw new NullPointerException("This deque does not permit null elements");
    }
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
      E[] d = (E[])new Object[data.length*2+1];
      if (start <= end){
        for (int i = start; i <= end; i ++){
          d[i-start] = data[i];
        }
      }else{
        for (int i = start; i <= end+data.length; i ++){
          if (i < data.length){
            d[i-start] = data[i];
          }else{
            d[i-start] = data[i-data.length];
          }
        }
      }
      start = 0;
      end = size-1;
      data = d;
    }
  }

  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException("This deque is empty");
    }
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
    if (size == 0){
      throw new NoSuchElementException("This deque is empty");
    }
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
    if (size == 0){
      throw new NoSuchElementException("This deque is empty");
    }
    return data[start];
  }

  public E getLast(){
    if (size == 0){
      throw new NoSuchElementException("This deque is empty");
    }
    return data[end];
  }
}
