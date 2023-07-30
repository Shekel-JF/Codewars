import java.math.BigInteger;
import java.util.*;
public class Kata
{
    public static int lastDigit(BigInteger n1, BigInteger n2)
    {
        if(n2.equals(BigInteger.valueOf(0)))
        {
            return 1;
        }
        List<Integer> ends = new ArrayList<>();
        int value = n1.mod(BigInteger.TEN).intValue();
        int tmp = value;
        while (!ends.contains(tmp%10))
        {
            ends.add(tmp%10);
            tmp*=value;
        }
        int index = n2.mod(BigInteger.valueOf(ends.size())).intValue();
        return ends.get((index + 3)%ends.size());
    }      
}