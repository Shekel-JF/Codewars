import java.util.*;
public class Shortener
{
    private String currStr = "aaaa";
    private Map<String, String> full = new HashMap<>();
    private Map<String, String> shortened = new HashMap<>();
    private int point = currStr.length() + 8;
    public String urlShortener(String longURL)
    {
        if(full.containsKey(longURL))
        {
            return full.get(longURL);
        }
      
        StringBuilder str = new StringBuilder("short.ly/");  
        str.append(currStr);
  
        while(str.charAt(point) == 'z')
        {
            str.setCharAt(point, 'a');
            point--;     
        }
        
        if(point < 9)
        {
            currStr = currStr.substring(0, currStr.length() - 1);
            point = currStr.length() + 8;
        }
        else
        {
            str.setCharAt(point, (char)(str.charAt(point) + 1));
        }
      
      
        full.put(longURL, str.toString());
        shortened.put(str.toString(), longURL);
        point = currStr.length() + 8;    
        currStr = str.substring(9, point + 1);
        
        return full.get(longURL);
    }
  
    
    public String urlRedirector(String shortURL)
    {
        return shortened.get(shortURL);
    }
}