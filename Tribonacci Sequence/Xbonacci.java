public class Xbonacci {

  public double[] tribonacci(double[] s, int n)
  {
      if(n == 0)
      {
          return new double[]{};
      }
      else if(n == 1)
      {
          return new double[]{s[0]};
      }
      else if(n == 2)
      {
          return new double[]{s[0], s[1]};
      }


      double a = s[0];
      double b = s[1];
      double c = s[2];
      double[] result = new double[n];
      result[0] = a;
      result[1] = b;
      result[2] = c;
    
      for(int x = 3; x < n; x++)
      {
          double tmp1 = b;
          double tmp2 = a;
          a = b;
          b = c;
          c = c + tmp1 + tmp2;
          result[x] = c;
      }
      return result;
  }
}