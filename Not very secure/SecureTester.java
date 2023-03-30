public class SecureTester
{
  
  public static boolean alphanumeric(String s)
  {
    if(s.equals(""))
    {
      return false;
    }
    char[] str = s.toCharArray();
    for(int i : str)
    {
        if((i < 48) || (i > 57 && i < 65) || (i > 90 && i < 97) || i > 122)
        {
            return false;
        }
    }
    
    return true;
  }

}