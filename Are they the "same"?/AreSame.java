public class AreSame
{	
	public static boolean comp(int[] a, int[] b)
  {
    if (a == null || b == null)
    {
        return false;
    }
    if (a.length != b.length)
    {
        return false;
    }
    
      for(int y = 0; y < b.length; y++)
      {
          for(int x = 0; x < a.length; x++)
          {
              if(a[x] * a[x] == b[y])
              {
                  a[x] = 0;
                  break;
              }
              else if(x == a.length - 1)
              {
                  return false;
              }
          }
      }
      return true;
  }
}