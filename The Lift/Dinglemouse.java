import java.util.*;
public class Dinglemouse
{
    static List<Integer> result;
    static List<Integer> people;
    static private int curr = 0;
    public static int[] theLift(final int[][] queues, final int capacity)
    {  
        curr = 0;
        result = new ArrayList<>();
        people = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
      
        for(int i = 0; i < queues.length; i++)
        {
            List<Integer> list = new ArrayList<>();
            for(int j : queues[i])
            {
                list.add(j);
            }
            map.put(i, list);
        }
      
        boolean loop = true;
        while(loop)
        {
            loop = false;
            goUp(map, capacity);
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            {
                if(!entry.getValue().isEmpty())
                {
                    loop = true;
                    break;
                }
            }        
            goDown(map, capacity);
        }
      
        if(result.size() == 0)
        {
            return new int[]{0};
        }
      
        if(result.get(result.size() - 1) != 0)
        {
            result.add(0);
        }
      
        if(result.get(0) != 0)
        {
            result.add(0, 0);
        }
        
        int[] res = new int[result.size()];
        for(int a = 0; a < result.size(); a++)
        {
            res[a] = result.get(a);
        }
        return res;
    }

  
    public static void goUp(Map<Integer, List<Integer>> map, final int capacity)
    {      
        while(true)
        {
            boolean keepGoing = false;
            boolean stop = false;
          
            if(!people.isEmpty())
            {
                Iterator<Integer> iterator = people.iterator();
                while(iterator.hasNext())
                {
                    int person = iterator.next();             
                    if(person > curr)
                    {
                        keepGoing = true;
                    }
                    if(person == curr)
                    {
                        iterator.remove();
                        stop = true;
                    }
                }
            }
            
            if(map.get(curr).size() > 0)
            {
                Iterator<Integer> iterator = map.get(curr).iterator();
                while(iterator.hasNext())
                {
                    int person = iterator.next();
                    if(person > curr)
                    {
                        if(people.size() < capacity)
                        {
                            people.add(person);
                            iterator.remove();
                            keepGoing = true;
                        }
                        stop = true;
                    }               
                }
            }
          
            if(keepGoing == false)
            {
                for(int k = curr + 1; k < map.size(); k++)
                {
                    if(!map.get(k).isEmpty())
                    {
                        keepGoing = true;
                        break;
                    }
                }
            }
          
            if(stop)
            {
                if(result.isEmpty() || result.get(result.size() - 1) != curr)
                {
                    result.add(curr);
                }      
            }     
          
            if(keepGoing == true)
            {
                curr++;
                continue;
            }        
            break;  
        }   
    }
  
    public static void goDown(Map<Integer, List<Integer>> map, final int capacity)
    {      
        while(true)
        {
            boolean keepGoing = false;
            boolean stop = false;
          
            if(!people.isEmpty())
            {
                Iterator<Integer> iterator = people.iterator();
                while(iterator.hasNext())
                {
                    int person = iterator.next();              
                    if(person < curr)
                    {
                        keepGoing = true;
                    }
                    if(person == curr)
                    {
                        iterator.remove();
                        stop = true;
                    }
                }
            }
            
            if(map.get(curr).size() > 0)
            {
                Iterator<Integer> iterator = map.get(curr).iterator();
                while(iterator.hasNext())
                {
                    int person = iterator.next();
                    if(person < curr)
                    {
                        if(people.size() < capacity)
                        {
                            people.add(person);
                            iterator.remove();                      
                            keepGoing = true;
                        }                    
                        stop = true;
                    }                
                }
            }
          
            if(keepGoing == false)
            {
                for(int k = curr - 1; k >= 0; k--)
                {
                    if(!map.get(k).isEmpty())
                    {
                        keepGoing = true;
                        break;        
                    }
                }
            }
            
            if(stop)
            {
                if(result.isEmpty() || result.get(result.size() - 1) != curr)
                {
                    result.add(curr);
                }      
            }
          
            if(keepGoing == true)
            {
                curr--;
                continue;
            }
          
            break;    
        }
    }
}