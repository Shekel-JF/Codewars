import java.util.Arrays;
public class Kata
{
    public static long nextBiggerNumber(long n)  
    {
      System.out.println(n);
      char [] s = String.valueOf(n).toCharArray();
      for(int i = s.length - 2; i >= 0; i--)
      {
           if(s[i] < s[i + 1])
           {
                int smallestIndex = i + 1;
                for(int j = i + 1; j < s.length; j++)
                { 
                    if(s[j] < s[smallestIndex] && s[j] > s[i])
                    {
                        smallestIndex = j;
                    }
                }
                char tmp = s[i];
                s[i] = s[smallestIndex];
                s[smallestIndex] = tmp;
                Arrays.sort(s, i + 1, s.length);
                return Long.valueOf(String.valueOf(s));          
           }
      }
      return -1;
    }
}