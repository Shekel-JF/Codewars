import java.util.*;
public class Decompose {

  public String decompose(long x)
  {
      String result = "";
      long sum = x*x;
      long tmp = sum;
      while(tmp!= 0 && x > 0)
      {
          tmp = sum;
          long n = x;
          result = "";
          while(tmp > 0 && n > 0)
          {
              if(tmp - (n - 1)*(n - 1) >= 0)
              {
                  tmp -= (n - 1)*(n - 1);
                  result+=Long.toString(n - 1) + " ";
              }
              n--;
          }
          x--;        
      }
      if(result.equals("0 "))
      {
          return null;
      }
    
      String[] array = result.split(" ");
      result = "";
      for(int s = array.length - 1; s >= 0; s--)
      { 
          result+=array[s] + " ";   
      }

      return result.trim();  
  }
}