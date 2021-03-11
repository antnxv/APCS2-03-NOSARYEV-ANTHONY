public class Quick{
  public static int quickselect(int[] data, int k){
    return 0;
  }

  public static int partition(int[] data, int lo, int hi){
    int mid = (lo + hi)/2;
    int j;
    if (data[mid] > data[lo] && data[mid] < data[hi]
       || data[mid] < data[lo] && data[mid] > data[hi]){
      j = mid;
    }else if(data[lo] > data[mid] && data[lo] < data[hi]
       || data[lo] < data[mid] && data[lo] > data[hi]){
      j = lo;
    }else{
      j = hi;
    }
    System.out.println("data["+j+"] = "+data[j]);
    for (int i = lo; i <= hi; i ++){
      if (i < j && (data[i] > data[j] || (data[i] == data[j] && Math.random()*2 == 0))){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        j = i;
      }
      else if (i > j && (data[i] < data[j] || (data[i] == data[j] && Math.random()*2 == 0))){
        int temp = data[i];
        data[i] = data[j+1];
        data[j+1] = data[j];
        data[j] = temp;
        j ++;
      }
    }
    return j;
  }
}
