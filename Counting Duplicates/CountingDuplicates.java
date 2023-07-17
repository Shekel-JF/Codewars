mport java.util.*;
public class CountingDuplicates
{
  public static int duplicateCount(String text)
  {
      int result = 0;
      Map<Character, Integer> map = new HashMap<>();
      char[] array = text.toCharArray();  
      for(int n = 0; n < array.length; n++)
      {
          if(Character.isUpperCase(array[n]))
          {
              array[n]+=32;
          }
          map.put(array[n], map.getOrDefault(array[n], 0) + 1);
      }
      
      for(Map.Entry<Character, Integer> entry : map.entrySet())
      {
          if(entry.getValue() > 1)
          {
              result++;
          }
      }
    
      return result;
  }
}