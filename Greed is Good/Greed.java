import java.util.*;
public class Greed
{
    public static int greedy(int[] dice)
    {
        int score = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : dice)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            while(entry.getValue() > 0)
            {
                if(entry.getValue() >=3)
                {
                    score+=entry.getKey() * 100;
                    if(entry.getKey() == 1)
                    {
                        score*=10;
                    }
                    map.put(entry.getKey(), map.get(entry.getKey()) - 3);
                    continue;
                }
              
                if(entry.getKey() == 1)
                {
                    score+=100;
                    map.put(entry.getKey(), map.get(entry.getKey()) - 1);
                }
                else if(entry.getKey() == 5)
                {
                    score+=50; 
                    map.put(entry.getKey(), map.get(entry.getKey()) - 1);
                }
                else
                {
                    break;
                }
            }          
        }
        return score;
    }   
}