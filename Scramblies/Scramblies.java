import java.util.*;
public class Scramblies
{   
    public static boolean scramble(String str1, String str2)
    { 
        Map<Character, Integer> map = new HashMap<>();
        for(char x : str2.toCharArray())
        {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
      
        for(char y : str1.toCharArray())
        {
            map.put(y, map.getOrDefault(y, 0) - 1);   
        }
      
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 0)
            {
                return false;
            }
        }
        return true;
    }
}