public class ProdFib
{
	public static long[] productFib(long prod)
    {
        long[] res = new long[3];
        long a = 0;
        long b = 1;
        long tmp = 0;
        while(a * b < prod)
        {
            tmp = b;
            b = a + b;
            a = tmp;
        }
        res[0] = a;
        res[1] = b;
        res[2] = (a * b == prod) ? 1 : 0;
    
		return res;
   }
}