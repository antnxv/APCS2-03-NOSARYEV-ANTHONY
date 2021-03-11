public class Quick{
  public static int quickselect(int[] data, int k){
    return 0;
  }

  public static int partition(int[] data, int lo, int hi){
    int j = (lo + hi)/2;
    for (int i = lo; i <= hi; i ++){
      if (data[i] > data[j] && i < j || data[i] == data[j] && Math.random()*2 == 0){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        j = i;
      }
      else if (data[i] < data[j] && i > j || data[i] == data[j]){
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
