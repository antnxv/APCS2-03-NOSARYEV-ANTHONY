import java.util.*;

public class Calculator{
  public static double eval(String s){
    Stack<Double> st = new Stack<Double>();
    Scanner eq = new Scanner(s);
    while (eq.hasNext()){
      String token = eq.next();
      switch (token){
        case "+": st.push(st.pop() + st.pop());
                  break;
        case "-": st.push(st.pop() - st.pop());
                  break;
        case "*": st.push(st.pop() * st.pop());
                  break;
        case "/": st.push(st.pop() / st.pop());
                  break;
        case "%": st.push(st.pop() % st.pop());
                  break;
        default:  st.push(Double.parseDouble(token));
                  break;
      }
    }
    return st.pop();
  }
}
