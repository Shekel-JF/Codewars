import java.util.*;
public class Kata
{
  public static long nextSmaller(long n)
  {
      String numString = Long.toString(n);
      int length = numString.length();
      char[] digits = numString.toCharArray();
      String toAdd = "";

      for(int i = length - 1; i > 0; i--)
      {
          if(digits[i - 1] > digits[i])
          {
              int highestIndex = i;
              for(int j = i; j < length; j++)
              {

                  if(digits[j] > digits[highestIndex] && digits[j] < digits[i-1])
                  {
                      highestIndex = j;
                  }
              }
              char tmp = digits[i - 1];
              digits[i - 1] = digits[highestIndex];
              digits[highestIndex] = tmp;

              char[] toSort = new char[length - i];
              for(int k = 0; k < length - i; k++)
              {
                  toSort[k] = digits[length - 1 - k];
              }
              Arrays.sort(toSort);
        
              String result = "";
              for(int l = 0; l < length - toSort.length; l++)
              {
                  if(digits[0] == '0')
                  {
                      return -1;
                  }
                  result+=digits[l];
              }
              for(int m = toSort.length - 1; m >= 0; m--)
              {
                  result+=toSort[m];
              }
              if(Long.parseLong(result) < n)
              {
                  return Long.parseLong(result);
              }
          }   
      }
      return -1;
  }
}