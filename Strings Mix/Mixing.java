import java.util.*;
public class Mixing
{ 
    public static String mix(String s1, String s2)
    {      
        List<String> characters = new ArrayList<>();        
        for(char c = 'a'; c <= 'z'; c++)
        {
            String tmp1 = s1.replaceAll("[^"+c+"]+","");
            String tmp2 = s2.replaceAll("[^"+c+"]+","");
          
            int length1 = tmp1.length();
            int length2 = tmp2.length();
          
            if(length1 > 1 || length2 > 1)
            {
                if(length1 > length2)
                {
                    characters.add("1:" + tmp1);
                }
                else if(length2 > length1)
                {
                    characters.add("2:" + tmp2);
                }
                else
                {
                    characters.add("=:" + tmp1);
                }
            }
        }     
        Collections.sort(characters, new CustomCompare());
      
      
        StringBuilder result = new StringBuilder();
        for(String s : characters)
        {
            result.append(s);
            result.append("/");
        }
        if(result.length() > 0)
        {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();     
    }

    public static class CustomCompare implements Comparator<String>
    {
        @Override
        public int compare(String str1, String str2)
        {
            if (str1.length() == str2.length())
            {
                if(str1.charAt(0) == str2.charAt(0))
                {
                    return Character.compare(str1.charAt(2), str2.charAt(2));
                }
                else
                {
                    return Character.compare(str1.charAt(0), str2.charAt(0));
                }          
            }
            return Integer.compare(str2.length(), str1.length());
        }
    }
}