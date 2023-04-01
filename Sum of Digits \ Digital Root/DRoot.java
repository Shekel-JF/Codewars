import java.util.ArrayList;
public class DRoot
{
  public static int digital_root(int number)
  {     
        while(number > 9)
        {
            ArrayList<Integer> list = new ArrayList<>();
            while(number > 0)
            {
                list.add(number % 10);
                number/=10;
            }
            number = 0;
            for(int x : list)
            {
              number+=x;
            }           
        }
        return number;
  }
}