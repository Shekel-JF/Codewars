public class Kata
{
    public static int maxContiguousSum(final int[] arr)
    {
        int result = 0;
        int sum = 0;
        for (int n : arr)
        {
            sum = Math.max(sum + n, 0);
            result = Math.max(sum, result);
        }
        return result;    
    }
} 