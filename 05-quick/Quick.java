public class Quick{

  public static void quicksort(int[] data){
    quicksort(data, 0, data.length-1);
  }
  public static void quicksort(int[] data, int lo, int hi){
    if (hi > lo){
      int j = partition(data, lo, hi);
      quicksort(data, lo, j-1);
      quicksort(data, j+1, hi);
    }
  }

  public static void quicksortDutch(int[] data){
    quicksortDutch(data, 0, data.length-1);
  }
  public static void quicksortDutch(int[] data, int lo, int hi){
    if (hi > lo){
      int[] j = partitionDutch(data, lo, hi);
      quicksortDutch(data, lo, j[0]-1);
      quicksortDutch(data, j[1]+1, hi);
    }
  }

  public static int quickselect(int[] data, int k){
    int j = partition(data, 0, data.length-1);
    if (j == k) return data[j];
    if (j < k){
      int [] newdata = new int[data.length-(j+1)];
      for (int i = 0; i < newdata.length; i ++){
        newdata[i] = data[j+1+i];
      }
      return quickselect(newdata, k-(j+1));
    }else{
      int[] newdata = new int[j];
      for (int i = 0; i < newdata.length; i ++){
        newdata[i] = data[i];
      }
      return quickselect(newdata, k);
    }
  }

  public static int quickselectDutch(int[] data, int k){
    int[] j = partitionDutch(data, 0, data.length-1);
    int lt = j[0];
    int gt = j[1];
    if (lt <= k && gt >= k) return data[k];
    if (gt < k){
      int [] newdata = new int[data.length-(gt+1)];
      for (int i = 0; i < newdata.length; i ++){
        newdata[i] = data[gt+1+i];
      }
      return quickselectDutch(newdata, k-(lt+1));
    }else{
      int[] newdata = new int[lt];
      for (int i = 0; i < newdata.length; i ++){
        newdata[i] = data[i];
      }
      return quickselectDutch(newdata, k);
    }
  }

  public static int partition(int[] data, int lo, int hi){
    int j = (int) (lo + Math.random()*(hi-lo+1));
    for (int i = lo; i <= hi; i ++){
      if (i < j && (data[i] > data[j] || (data[i] == data[j] && ((int) (Math.random()*2) == 0)))){
        int temp = data[j];
        data[j] = data[i];
        data[i] = temp;
        j = i;
      }
      else if (i >= j && data[i] < data[j]){
        int temp = data[j];
        data[j] = data[i];
        data[i] = data[j+1];
        data[j+1] = temp;
        j ++;
      }
    }
    return j;
  }

  public static int[] partitionDutch(int[] data, int lo, int hi){
    int lt = lo;
    int gt = lo;
    for (int i = lo+1; i <= hi; i ++){
      if (data[i] <= data[gt]){
        int temp = data[lt];
        data[lt] = data[i];
        data[i] = data[gt+1];
        data[gt+1] = temp;
        gt ++;
        if (data[lt] != data[gt]){
          lt ++;
        }
      }
    }
    int[] sub = {lt, gt};
    return sub;
  }
}
