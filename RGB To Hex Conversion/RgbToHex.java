public class RgbToHex
{
    public static String rgb(int r, int g, int b)
    {
        int[] entry = new int[]{r, g, b};
        for(int x = 0; x < 3; x++)
        {
            if(entry[x] < 0)
            {
                entry[x] = 0;
            }
            else if(entry[x] > 255)
            {
                entry[x] = 255;
            }
        }      
        return String.format("%02X%02X%02X", entry[0], entry[1], entry[2]);
    }
}