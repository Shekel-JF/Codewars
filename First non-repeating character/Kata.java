import java.util.*;
public class Kata
{
    public static String firstNonRepeatingLetter(String s)
    {  
        char[] lettersArray = s.toCharArray();
        Map<String, Integer> letters = new HashMap<>();

        for(char c : lettersArray)
        {
            String letter = String.valueOf(c);
            if(letters.containsKey(letter.toUpperCase()))
            {
                letter = letter.toUpperCase();
            }
            else if(letters.containsKey(letter.toLowerCase()))
            {
                letter = letter.toLowerCase();
            }
             
            letters.put(letter, letters.getOrDefault(letter, 0) + 1);
        }

        for(char c : lettersArray)
        {
            String letter = String.valueOf(c);
            if(letters.containsKey(letter) && letters.get(letter) == 1)
            {
                return letter;
            }
        }
        return "";
    }
}