public class StripComments
{
	  public static String stripComments(String text, String[] commentSymbols)
    {
        StringBuilder result = new StringBuilder();
        String[] chars = text.split("");
        String symbols = String.join("", commentSymbols);
        boolean newLine = false;

        for(int c = 0; c < chars.length; c++)
        {
            if(!symbols.contains(chars[c]) && !newLine)
            {
                if(chars[c].contains("\n"))
                {
                    result = new StringBuilder(result.toString().replaceAll("\\h+$", ""));
                }
                result.append(chars[c]);
            }
            else
            {
                newLine = true;
                result = new StringBuilder(result.toString().replaceAll("\\h+$", ""));
                if(chars[c].contains("\n"))
                {  
                    result.append(chars[c]);
                    newLine = false;
                }
            }
        }
		    return result.toString().replaceAll("\\h+$", "");
	  }
}