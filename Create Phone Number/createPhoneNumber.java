public class Kata
{
  public static String createPhoneNumber(int[] numbers)
  {
    String res = "(";
    for(int i = 0; i < 3; i++)
    {
      res+=Integer.toString(numbers[i]);
    }
    res+=") ";
    for(int i = 3; i < 6; i++)
    {
      res+=Integer.toString(numbers[i]);
    }
    res+="-";
    for(int i = 6; i < 10; i++)
    {
      res+=Integer.toString(numbers[i]);
    }
    return res;
  }
}