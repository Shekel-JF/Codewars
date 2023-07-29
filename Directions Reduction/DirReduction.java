import java.util.*;
public class DirReduction
{
    public static String[] dirReduc(String[] arr)
    {
        List<String> array = new ArrayList<>(Arrays.asList(arr));
        int length = array.size();
        for (int i = 0; i < length - 1; i++)
        {
            if ((array.get(i).equals("SOUTH") && array.get(i + 1).equals("NORTH"))
            || (array.get(i).equals("NORTH") && array.get(i + 1).equals("SOUTH"))
            || (array.get(i).equals("WEST") && array.get(i + 1).equals("EAST"))
            || (array.get(i).equals("EAST") && array.get(i + 1).equals("WEST")))
            {
                array.remove(i);
                array.remove(i);
                length -= 2;
                i -= 2; 
                if (i < -1)
                {
                    i = -1;
                }   
            }
        }
        String[] result = new String[length];
        for(int s = 0; s < length; s++)
        {
            result[s] = array.get(s);
        }
        return result;
    }
}