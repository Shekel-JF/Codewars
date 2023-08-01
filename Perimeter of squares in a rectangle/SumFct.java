import java.math.BigInteger;

public class SumFct
{
    public static BigInteger perimeter(BigInteger n)
    {
        BigInteger three = BigInteger.valueOf(3);
        BigInteger fibNPlus3 = fib(n.add(three));
        BigInteger perimeter = fibNPlus3.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(4));
        return perimeter;
    }
    private static BigInteger fib(BigInteger n)
    {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < n.intValue(); i++)
        {
            BigInteger tmp = a.add(b);
            a = b;
            b = tmp;
        }
        return a;
    }
}