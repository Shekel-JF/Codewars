import java.util.*;
public class ScreenLock
{
    private static Map<String, List<String>> graph = new HashMap<>();
    static
    {
        graph.put("A", Arrays.asList("BC", "DG", "EI", "F", "H"));
        graph.put("B", Arrays.asList("A", "C", "D", "EH", "F", "G", "I"));
        graph.put("C", Arrays.asList("BA", "D", "EG", "FI", "H"));
        graph.put("D", Arrays.asList("A", "B", "C", "EF", "G", "H", "I"));
        graph.put("E", Arrays.asList("A", "B",  "C", "D", "F", "G", "H", "I"));
        graph.put("F", Arrays.asList("A", "B", "C", "ED", "G", "H", "I"));
        graph.put("G", Arrays.asList("DA", "B", "EC", "F", "HI"));
        graph.put("H", Arrays.asList("A", "EB", "C", "D", "F", "G", "I"));
        graph.put("I", Arrays.asList("EA", "B", "FC", "D", "HG"));
    }
  
    public int calculateCombinations(char startPosition, int patternLength)
    {
        int result = 0;
        if(patternLength < 1 || patternLength > 9 || graph.get(startPosition + "") == null)
        {
            return result;
        }
        else
        {
            String nodes = "ABCDEFGHI";
            result = recurse(startPosition + "", patternLength - 1, nodes.replace(startPosition + "", ""));
        }  
        return result;
    }
  
    public int recurse(String currentPosition, int steps, String nodes)
    {
        int result = 0;
        if(steps == 0)
        {
            result = 1;
        }
        else if(steps > 0)
        {
            for(String s : graph.get(currentPosition))
            {
                for(String c : s.split(""))
                {
                    if(nodes.contains(c))
                    {
                        result += recurse(c, steps - 1, nodes.replace(c, ""));
                        break;
                    }
                }
            }
        }
        return result;
    }
}