import java.util.*;
public class TimeFormatter {
    
    public static String formatDuration(int seconds) {
        // your code goes here
      
        if(seconds==0)
        {
            return "now";  
        }
        
        String Y = Integer.toString(seconds/ 31536000);
        String D = Integer.toString((seconds % 31536000) / 86400);
        String H = Integer.toString(((seconds % 31536000) % 86400) / 3600);
        String M = Integer.toString((((seconds % 31536000) % 86400) % 3600) / 60);
        String S = Integer.toString((((seconds % 31536000) % 86400) % 3600) % 60);
        
        String[] strs = {Y, D, H, M, S};
        String[] labels = {" year", " day", " hour", " minute", " second"};
        String res = "";
        
        
        for(int i = 0; i < 5; i++)
        {
            if(!strs[i].equals("0"))
            {
                
                if(!strs[i].equals("1"))
                {
                    labels[i]+= "s";  
                } 
                strs[i] = String.join("", strs[i], labels[i]);
            }
        }
        List<String> wordList = new ArrayList<String>(Arrays.asList(strs));
        Iterator<String> iter = wordList.iterator();
        while(iter.hasNext())
        {
            String x = iter.next();
            if(x.equals("0"))
            {
                iter.remove();
            }
        }
        
        for(int j = 0; j < wordList.size(); j++)
        {
            res+=wordList.get(j);
            if(wordList.size() > 1 && j == wordList.size() -2)
            {
                res+=" and ";
            }
            else if(wordList.size() > 1 && j != wordList.size() -1)
            {
                res+=", ";
            }
        }
        
        return res;
        
        
        
    }
}