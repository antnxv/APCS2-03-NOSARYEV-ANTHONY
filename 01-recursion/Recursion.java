public class Recursion{

  public static String reverse(String s){
    if (s.length() < 2){
      return s;
    }
    return reverse(s.substring(1)) + s.charAt(0);
  }

  public static long countNoDoubleLetterWords(int length, String word){
    if (length == 0){
      return 1;
    }else{
      long count = 0;
      for (char i = 'a'; i <= 'z'; i ++){
        if (word.length() == 0 || word.charAt(word.length()-1) != i){
          count += countNoDoubleLetterWords(length-1, word + i);
        }
      }
      return count;
    }
  }

  public static double sqrt(double n){
    if (n < 0) return Double.NaN;
    if (n == 0) return 0.0;
    return sqrt(n, 1);
  }

  public static double sqrt(double n, double n_){
    if (Math.abs((n_*n_ / n)-1) <= 0.00001){
      return n_;
    }else{
      return sqrt(n, (n/n_ + n_)/2);
    }
  }
}
