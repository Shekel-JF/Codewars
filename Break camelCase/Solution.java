import java.lang.Character;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
class Solution
{
  public static String camelCase(String input)
  {
      ArrayList<Character> chars = new ArrayList<>();
      for (char c : input.toCharArray())
      {
          if(Character.isUpperCase(c))
          {
              chars.add(' ');
          }
          chars.add(c);
      }
      return StringUtils.join(chars, null);
  }
}