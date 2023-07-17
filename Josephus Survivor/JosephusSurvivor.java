import java.util.*;

public class JosephusSurvivor
{
    public static int josephusSurvivor(final int n, final int k)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1)
        {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }
}