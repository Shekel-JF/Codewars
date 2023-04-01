import java.util.Arrays;
public class TwoToOne
{  
    public static String longest (String s1, String s2)  
    {
        char[] str = (s1 + s2).toCharArray();
        int n = str.length;
        char[] res = new char[n];

        int temp = 0;
        for (int i = 0; i < n; i++)
        {
            int j;
            for (j = 0; j < i; j++)
            {
                if (str[i] == str[j])
                {
                    break;
                }
            }
            if (j == i)
            {
                res[temp++] = str[i];
            }
        }
        res = Arrays.copyOf(res, temp);
        Arrays.sort(res);
        return (new String(res));
      }
}