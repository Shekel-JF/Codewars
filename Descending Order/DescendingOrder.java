import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder
{
  public static int sortDesc(final int num)
  {
    String temp = Integer.toString(num);
    Integer[] digits = new Integer[temp.length()];
    for (int i = 0; i < temp.length(); i++)
    {
        digits[i] = temp.charAt(i) - '0';
    }
    Arrays.sort(digits, Collections.reverseOrder());
    int res = 0;
    for(int x : digits)
    {
        res = 10 * res + x;
    }
    return res;
  }
}