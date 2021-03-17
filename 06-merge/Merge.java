public class Merge{

  public static void mergesort(int[] data){
    mergesort(data, new int[data.length], 0, data.length-1);
  }
  public static void mergesort(int[] data, int[] temp, int lo, int hi){
    if (hi != lo){
      int split = (hi+lo)/2;
      mergesort(data, new int[split-lo+1], lo, split);
      mergesort(data, new int[hi-split], split+1, hi);
      int le = lo;
      int ri = split+1;
      for (int i = 0; i <= hi-lo; i ++){
        if (ri > hi || le < split+1 && data[le] < data[ri]){
          temp[i] = data[le];
          le ++;
        }else{
          temp[i] = data[ri];
          ri ++;
        }
      }
      for (int i = 0; i <= hi-lo; i ++){
        data[lo+i] = temp[i];
      }
    }
  }
}
