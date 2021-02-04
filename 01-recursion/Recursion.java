public class Recursion{

  public static String reverse(String s) {
    if (s.length() < 2){
      return s;
    }
    return reverse(s.substring(1)) + s.charAt(0);
  }

  //public static long countNoDoubleLetterWords(int length, String word){}

  //public static double sqrt(double n){}

}
