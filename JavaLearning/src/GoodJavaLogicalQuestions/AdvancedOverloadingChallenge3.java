package GoodJavaLogicalQuestions;

public class AdvancedOverloadingChallenge3 {
  static String x = "";
  public static void main(String... doYourBest) {
     executeAction(1);
     //1 is an int so here widening is done from int ->long->float
     executeAction(1.0);
     //1.0 is acted as double 
     executeAction(Double.valueOf("5"));
     executeAction(1L);
    
     System.out.println(x);
  }
  static void executeAction(int ... var) {x += "a"; }
  static void executeAction(Integer var) {x += "b"; }
  static void executeAction(Object var)  {x += "c"; }
  static void executeAction(short var)   {x += "d"; }
  static void executeAction(float var)   {x += "e"; }
  static void executeAction(double var)  {x += "f"; }
}