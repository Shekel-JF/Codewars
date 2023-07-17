public class TimeFormatter
{  
    public static String formatDuration(int seconds)
    {
        if(seconds == 0)
        {
            return "now";
        }
        int years = seconds / 60 / 60 / 24 / 365;
        int days = seconds / 60 / 60 / 24 % 365;
        int hours = seconds / 60 / 60 % 24;
        int minutes = seconds / 60 % 60;
        int secs = seconds % 60;
        String result = "";
        int counter = 0;
      
        int[] times = new int[]{years, days, hours, minutes, secs};
        String[] formats = new String[]{"year", "day", "hour", "minute", "second"};
      
        for(int i = 0; i < 5; i++)
        {
            if(times[i] > 1)
            {
                formats[i]+="s";
            }
            if(times[i] > 0)
            {
                counter++;
            }
        }
             
        for(int j = 0; j< 5; j++)
        {
            if(times[j] !=0)
            {
                result+= times[j] + " " + formats[j];
            }
            else
            {
                continue;
            }
            if(counter > 1)
            {
                if(counter == 2)
                {
                    result+=" and ";
                }
                else
                {
                    result+=", ";
                }
                counter--;
            }
        }
    return result;
    }
}