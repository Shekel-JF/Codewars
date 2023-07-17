import java.util.*;
public class DuplicateEncoder
{
	static String encode(String word)
  {
      String res = "";
      Map<Character, Integer> map = new HashMap<>();
      char[] array = word.toCharArray();
    
      for(int n = 0; n < array.length; n++)
      {
          if(Character.isUpperCase(array[n]))
          {
              array[n]+=32;
          }
          map.put(array[n], map.getOrDefault(array[n], 0) + 1);
      }
    
      for(char m : array)
      {
          if(map.get(m)!=null)
          {
              if(map.get(m) > 1)
              {
                  res+= ")";
              }
              else
              {
                  res+= "(";
              }
          }
      }
    
      return res;
  }
}