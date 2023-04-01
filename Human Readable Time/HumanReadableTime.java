public class HumanReadableTime
{
  public static String makeReadable(int seconds)
  {
    String HH = Integer.toString(seconds/3600);
    String MM = Integer.toString((seconds % 3600) / 60);
    String SS = Integer.toString((seconds % 3600) % 60);
    
    if(HH.length() == 1)
        HH = '0' + HH;
    if(MM.length() == 1)
        MM = '0' + MM;
    if(SS.length() == 1)
        SS = '0' + SS;

    String res = "";
    res+= HH + ':' + MM + ':' + SS;
    
    return res;
  }
}