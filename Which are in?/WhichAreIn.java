import java.util.ArrayList;
import java.util.Arrays;

public class WhichAreIn
{
    public static String[] inArray(String[] array1, String[] array2)
    {
        ArrayList<String> res = new ArrayList<>();

        for (String n : array1)
        {
            for (String m : array2)
            {
                if (m.contains(n))
                {
                    res.add(n);
                    break;
                }
            }
        }

        String[] resultArray = new String[res.size()];
        res.toArray(resultArray);
        Arrays.sort(resultArray);
        return resultArray;
    }
}