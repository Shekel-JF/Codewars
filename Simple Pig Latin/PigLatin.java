import java.util.*;
public class PigLatin {
    public static String pigIt(String str)
    {
        String result = "";
        List<String> s = Arrays.asList(str.split(" "));
        for(String a : s)
        {
            if(a.charAt(0) == '!' || a.charAt(0) == '?')
            {
                result+=a;
                continue;
            }
            a+=a.charAt(0) + "ay";          
            result+=a.substring(1) + " ";
        }  
        return result.trim();     
    }
}