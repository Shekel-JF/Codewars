public class Dinglemouse
{
    public static int countDeafRats(final String town)
    {
        char[] arr = town.replaceAll(" ", "").toCharArray();
        int result = 0;
        for(int i = 0; i < arr.length; i+=2)
        {
            if(arr[i] == 'O')
            {
                result++;
            }
        }
        return result;
    }
}