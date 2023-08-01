public class Kata
{
	public static String longToIP(long ip)
  {
    long div = 256 * 256 * 256;
    long[] octets = new long[4];
    octets[0] = ip/div;
    String result = String.valueOf(octets[0]);
    for(int i = 1; i < 4; i++)
    {   
        ip-=octets[i - 1] * div;
        div/=256;
        octets[i] = ip / div;
        result+="." + String.valueOf(octets[i]);
    }    
		return result;
	}
}