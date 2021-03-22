import java.util.*;

public class Calculator{
  public static double eval(String s){
    Stack<Double> st = new Stack<Double>();
    Scanner eq = new Scanner(s);
    while (eq.hasNext()){
      String token = eq.next();
      try{
        switch (token){
          case "+": st.push(st.pop() + st.pop());
                    break;
          case "-": st.push(-st.pop() + st.pop());
                    break;
          case "*": st.push(st.pop() * st.pop());
                    break;
          case "/": st.push(1.0/(st.pop() / st.pop()));
                    break;
          case "%": double temp = st.pop();
                    st.push(st.pop() % temp);
                    break;
          default:  st.push(Double.parseDouble(token));
                    break;
        }
      }catch (EmptyStackException e){
        throw new IllegalArgumentException("not enough operands");
      }
    }
    double ans = st.pop();
    if (st.empty()){
      return ans;
    }else{
      throw new IllegalArgumentException("too many operands");
    }
  }
}
