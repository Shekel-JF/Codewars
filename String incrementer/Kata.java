import java.math.BigInteger;

public class Kata
{
    public static String incrementString(String str)
    {
        String orNum = "";
        int length = 0;
        for (int i = str.length() - 1; i >= 0; i--)
        {
            if (str.charAt(i) > 47 && str.charAt(i) < 58)
            {
                orNum = str.charAt(i) + orNum;
                length++;
            }
            else
            {
                break;
            }
        }
        if (orNum.equals(""))
        {
            orNum = "0";
        }

        BigInteger numValue = new BigInteger(orNum);
        numValue = numValue.add(BigInteger.ONE);
        String value = numValue.toString();

        if (value.length() > orNum.length())
        {
            orNum += "0";
        }
        orNum = orNum.substring(0, orNum.length() - value.length());
        orNum += value;

        str = str.substring(0, str.length() - length);
        return str + orNum;
    }
}