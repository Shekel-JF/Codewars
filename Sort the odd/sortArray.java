import java.util.*;
public class Kata
{
  public static int[] sortArray(int[] array)
  {
      ArrayList<Integer> indexes = new ArrayList<>();
      ArrayList<Integer> tmp = new ArrayList<>();
      for(int n = 0; n < array.length; n++)
      {
          if(array[n] % 2 != 0)
          {
              indexes.add(n);
              tmp.add(array[n]);
          }
      }
      Collections.sort(tmp);
          
      for(int m : indexes)
      {
          if (!tmp.isEmpty())
          {
              array[m] = tmp.get(0);
              tmp.remove(0);
          }
          
      }   
    
      return array;
  }
}