public class ToSmallest
{
    public static long[] smallest(long n)
    {
        String s = String.valueOf(n);
        int length = s.length();
      
        String result = s;
        long digitTaken = 0;
        long insertionIndex = 0;

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (i == j)
                {
                    continue;
                }
                String tmp = s.substring(0, i) + s.substring(i + 1);
                tmp = tmp.substring(0, j) + s.charAt(i) + tmp.substring(j);
                if(result.compareTo(tmp) > 0)
                {
                    result = tmp;
                    digitTaken = i;
                    insertionIndex = j;
                }
            }
        }
        return new long[]{Long.valueOf(result), digitTaken, insertionIndex};
    }
}