import java.util.*;
public class Dinglemouse
{
  public static int[] dryGround(char[][] mountain)
  {
        char height = '1';
        char tmp = '0';
        int drySpots = 0;
        int[] result = new int[4];
        for(int x = 0; x < 4; x++)
        {
            height = tmp;
            for(int a = 0; a < mountain.length; a++)
            {
                for(int b = 0; b < mountain[a].length; b++)
                {
                    if(mountain[a][b]!='-')
                    {
                        drySpots++;
                    }
                }
            }
            result[x] = drySpots;
            tmp = replacer(mountain, height);
            for(int a = 0; a < mountain.length; a++)
            {
                for(int b = 0; b < mountain[a].length; b++)
                {
                    if(mountain[a][b]=='-')
                    {
                        flood(a, b, mountain, height);
                    }
                }
            }
            drySpots = 0;
        }
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
  
    public static void flood(int i, int j, char[][] mountain, char height)
    {
        if(i + 1 < mountain.length && mountain[i + 1][j] < height && mountain[i + 1][j] != '-')
        {
            mountain[i + 1][j] = '-';
            flood(i + 1, j, mountain, height);
        }
        if(i - 1 >= 0 && mountain[i - 1][j] < height && mountain[i - 1][j] != '-')
        {
            mountain[i - 1][j] = '-';
            flood(i - 1, j, mountain, height);
        }
        if(j + 1 < mountain[i].length && mountain[i][j + 1] < height && mountain[i][j + 1] != '-')
        {
            mountain[i][j + 1] = '-';
            flood(i, j + 1, mountain, height);
        }
        if(j - 1 >= 0 && mountain[i][j - 1] < height && mountain[i][j - 1] != '-')
        {
            mountain[i][j - 1] = '-';
            flood(i, j - 1, mountain, height);
        }
    }  
}