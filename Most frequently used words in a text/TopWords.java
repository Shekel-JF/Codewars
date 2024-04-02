import java.util.*;

public class TopWords
{   
    public static List<String> top3(String s)
    {
        s = s.replaceAll("[^\\p{L}']+", " ").toLowerCase();
        String[] words = s.split(" ");
      
        Map<String, Integer> wordCount = new HashMap<>();
        for(int i = 0; i < words.length; i++)
        {       
            if (!words[i].matches(".*[a-zA-Z].*"))
            {
                words[i] = words[i].replaceAll("'", "");
            }
            if(!words[i].equals(""))
            {
                wordCount.put(words[i], wordCount.getOrDefault(words[i], 0) + 1);
            }   
        }
      
        List<Map.Entry<String, Integer>> sortingList = new ArrayList<>(wordCount.entrySet());

        Collections.sort(sortingList, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2)
            {
                return entry2.getValue().compareTo(entry1.getValue());
            }
          
        });
        
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : sortingList)
        {
            result.add(entry.getKey());
            if(result.size() == 3)
            {
                break;
            }
        }    
      
        return result;
    }
}