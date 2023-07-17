public class CountIPAddresses
{
	public static long ipsBetween(String start, String end)
  {
      long result = 0;
      String[] array1 = start.split("\\.");
      String[] array2 = end.split("\\.");
      for(String a : array1)
      {
          System.out.println(a);
      }
      for(String b : array2)
      {
          System.out.println(b);
      }
      result = (Long.parseLong(array2[0]) - Long.parseLong(array1[0])) * (256 * 256 * 256) +
               (Long.parseLong(array2[1]) - Long.parseLong(array1[1])) * (256 * 256) +
               (Long.parseLong(array2[2]) - Long.parseLong(array1[2])) * 256 +
               (Long.parseLong(array2[3]) - Long.parseLong(array1[3])) * 1;
      return result;
	} 
}