import java.lang.Math;

public class PerfectPower
{
  public static int[] isPerfectPower(int n)
  {
      for(int i = 2; i <= Math.sqrt(n); i++)
      {    
          int pow = 2;
          while(Math.pow(i, pow) < n)
          {
              pow++;
          }
          if(Math.pow(i, pow) == n)
          {
              return new int[]{i, pow};
          }         
      }
      return null;
  }
}