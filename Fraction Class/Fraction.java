public class Fraction implements Comparable<Fraction>
{
    private final long top;
    private final long bottom;

    public Fraction(long numerator, long denominator)
    {
        top = numerator;
        bottom = denominator;
    }

    @Override
    public int hashCode()
    {
        return 17 * Long.hashCode(top) + Long.hashCode(bottom);
    }
    
    @Override
    public boolean equals(Object o)
    {
        return compareTo((Fraction)o) == 0;
    }
    
    @Override
    public int compareTo(Fraction f2)
    {
        return Long.compare(top * f2.bottom, f2.top * bottom);
    }
    
    public Fraction add(Fraction f2)
    {          
        long tmpBot = this.bottom * f2.bottom;
        long tmpTop = this.top * f2.bottom + this.bottom * f2.top;  
        long n = reduce(tmpTop, tmpBot);
        return new Fraction(tmpTop / n, tmpBot / n);
    }
    
    private long reduce(long a, long b)
    {
        if(b == 0)
        {
            return a;
        }
        return reduce(b, a % b);
    }
       
    @Override
    public String toString()
    {
        return Long.toString(this.top) + "/" + Long.toString(this.bottom);
    }
}