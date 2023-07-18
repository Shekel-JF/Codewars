import java.util.*;

class HowManyNumbers
{

    public static List<Long> findAll(final int sumDigits, final int numDigits)
    {
        long total = 0;
        long lowest = 0;
        long highest = 0;
        long num = 1;
      
        for (int a = numDigits; a > 0; a--)
        {
            num *= 10;
        }

        for (long i = num / 10; i < num; i++)
        {
            long tmp = (long) i;
            long sum = 0;
            long curr = Integer.MAX_VALUE;

            while (tmp > 0)
            {
                if (curr < tmp % 10)
                {                  
                    i = getNextAscendingNumber(i);
                    i--;
                    sum = 0;
                    break;
                }
                
                curr = tmp % 10;
                sum += curr;
                tmp /= 10;
            }

            if (sum == sumDigits)
            {           
                total++;
                if (lowest == 0)
                {
                    lowest = i;
                }
                highest = i;            
            }
        }

        List<Long> result = new ArrayList<>();
        if (total > 0)
        {
            result.add(total);
            result.add(lowest);
            result.add(highest);
        }

        return result;
    }

    private static long getNextAscendingNumber(long num)
    {
        String strNum = String.valueOf(num);
        int len = strNum.length();
        char[] digits = strNum.toCharArray();

        for (int i = len - 2; i >= 0; i--)
        {
            if (digits[i] > digits[i + 1])
            {
                digits[i + 1] = digits[i];
            }
        }

        return Long.parseLong(new String(digits));
    }
}
