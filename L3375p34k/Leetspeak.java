import java.util.*;
public class Leetspeak extends Encoder
{
    public String encode(String source)
    {
        System.out.println(source);
        if(source==null)
        {
            return "";
        }
        char[] array = source.toCharArray();
        String result = ""; 
        for(char c : array)
        {
            if(map.containsKey(Character.toLowerCase(c)))
            {
                result += map.get(Character.toLowerCase(c));
            }
            else
            {
                result += c;
            }
        }
        return result;
    } 
}

abstract class Encoder
{
    protected Map<Character, String> map = new HashMap<>();
    public Encoder()
    {
        map.put('a', "4");
        map.put('e', "3");
        map.put('l', "1");
        map.put('m', "/^^\\");
        map.put('o', "0");
        map.put('u', "(_)");
    }    
    public abstract String encode(String source);
}