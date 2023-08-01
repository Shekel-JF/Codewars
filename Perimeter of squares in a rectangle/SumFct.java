import java.math.BigInteger;

public class SumFct
{
    public static BigInteger perimeter(BigInteger n)
    {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger fibNPlus2 = fib(n.add(two));
        BigInteger perimeter = fibNPlus2.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(4));
        return perimeter;
    }
    private static BigInteger fib(BigInteger n)
    {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i <= n.intValue(); i++)
        {
            BigInteger tmp = a.add(b);
            a = b;
            b = tmp;
        }
        return a;
    }
}