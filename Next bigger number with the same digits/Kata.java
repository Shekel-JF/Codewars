import java.util.*;
public class Kata
{
    public static long nextBiggerNumber(long n)
    {
      String numString = Long.toString(n);
      int length = numString.length();
      char[] digits = numString.toCharArray();

      for(int i = length - 1; i > 0; i--)
      {
          if(digits[i - 1] < digits[i])
          {
              int lowestIndex = i;
              for(int j = i; j < length; j++)
              {
                  if(digits[j] < digits[lowestIndex] && digits[j] > digits[i-1])
                  {
                      lowestIndex = j;
                  }
              }
              char tmp = digits[i - 1];
              digits[i - 1] = digits[lowestIndex];
              digits[lowestIndex] = tmp;

              char[] toAdd = new char[length - i];
              for(int k = 0; k < length - i; k++)
              {
                  toAdd[k] = digits[length - 1 - k];
              }
              Arrays.sort(toAdd);
              String result = "";
              for(int l = 0; l < length - toAdd.length; l++)
              {
                  if(digits[0] == '0')
                  {
                      return -1;
                  }
                  result+=digits[l];
              }
              for(int m = 0; m < toAdd.length; m++)
              {
                  result+=toAdd[m];
              }
              if(Long.parseLong(result) > n)
              {
                  return Long.parseLong(result);
              }
          }   
      }
      return -1;
    }
}