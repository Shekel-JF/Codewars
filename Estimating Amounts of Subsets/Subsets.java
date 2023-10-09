import java.util.*;
import java.lang.Math;
public class Subsets
{  
    public static <T> long count(T[] elems)
    {     
        Set<T> set = new HashSet<>(Arrays.asList(elems));
        return (long)Math.pow(2, set.size()) - 1;
    }  
}