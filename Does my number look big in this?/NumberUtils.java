import java.util.ArrayList;
import java.lang.Math;
public class NumberUtils
{

    public static boolean isNarcissistic(int number)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = number;
        while(temp > 0)
        {
            list.add(temp % 10);
            temp/=10;
        }
      
      
        int res = 0;
        for(Integer x : list)
        {
            res+=Math.pow(x, list.size());
        }
        if(res==number)
        {
            return true; 
        }
        else
        {
            return false;
        }
        
    }

}