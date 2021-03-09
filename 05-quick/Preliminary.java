public class Preliminary{
  public static int partition(int[] data, int start, int end){
    int pivot = start + (int)(Math.random()*(end-start+1));
    for (int i = start; i <= end; i ++){
      if (data[i] >= data[pivot] && i < pivot){
        int temp = data[i];
        data[i] = data[pivot];
        data[pivot] = temp;
        pivot = i;
      }
      else if (data[i] < data[pivot] && i > pivot){
        int temp = data[i];
        data[i] = data[pivot+1];
        data[pivot+1] = data[pivot];
        data[pivot] = temp;
        pivot ++;
      }
    }
    return pivot;
  }
}
