import java.util.*;
public class Dinglemouse
{
    public static int peakHeight(char[][] mountain)
    {
        char height = '1';
        char tmp = '0';
        while(tmp!=height)
        {
            height = tmp;
            tmp = replacer(mountain, height);          
        }
        int result = height - '0';
        return result;
    }
  
    public static char replacer(char[][] mountain, char height)
    {
        boolean worked = false;
        List<Integer> i_replace = new ArrayList<>();
        List<Integer> j_replace = new ArrayList<>();
        for(int i = 0; i < mountain.length; i++)
        {
            for(int j = 0; j < mountain[i].length; j++)
            {
                if(mountain[i][j] == '^')
                {
                    if((i + 1 < mountain.length && i - 1 >= 0 && j + 1 < mountain[i].length && j - 1 >= 0) &&
                      (mountain[i + 1][j] != '^' || mountain[i - 1][j] != '^'|| mountain[i][j + 1] != '^'|| mountain[i][j - 1] !='^') ||
                      (i + 1 >= mountain.length || i - 1 < 0 || j + 1 >= mountain[i].length || j - 1 < 0))
                      {
                          i_replace.add(i);
                          j_replace.add(j);
                          worked = true;
                      }                   
                }
            }
        }
        for(int n = 0; n < i_replace.size(); n++)
        {
            mountain[i_replace.get(n)][j_replace.get(n)] = height;
        }
        if(worked)
        {
            height++;
        }
        return height;
    }
}