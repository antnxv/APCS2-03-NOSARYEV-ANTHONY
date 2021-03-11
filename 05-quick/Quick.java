public class Quick{
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
