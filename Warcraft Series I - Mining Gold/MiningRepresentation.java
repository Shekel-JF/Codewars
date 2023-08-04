import java.util.ArrayList;
import java.util.List;

//not really proud of the abomination below

public class MiningRepresentation
{
    public static List<String> generate(String path, int time)
    {
        char[] chars = path.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < time; i++)
        {
            result.add(new String(chars));
            int[] where = new int[chars.length];
            for(int j = 0; j < chars.length; j++)
            {
                if(chars[j] == '>')
                {
                    if(where[j + 1] == - 1 || where[j + 1] == 2)
                    {
                        where[j + 1] = 2;
                    }
                    else
                    {
                        where[j + 1] = 1;
                    }              
                }
                else if(chars[j] == '<')
                {
                    if(where[j - 1] == 1 || where[j - 1] == 2)
                    {
                        where[j - 1] = 2;
                    }
                    else
                    {
                        where[j - 1] = -1;
                    }              
                }
                else if(chars[j] == '#')
                {
                    if(where[j + 1] == - 1 || where[j + 1] == 2)
                    {
                        where[j + 1] = 2;
                    }
                    else
                    {
                        where[j + 1] = 1;
                    }
                    if(where[j - 1] == 1 || where[j - 1] == '#')
                    {
                        where[j - 1] = 2;
                    }
                    else
                    {
                        where[j - 1] = -1;
                    }
                }
                else if(chars[j] == '*')
                {
                    if(j == 0)
                    {
                        if(where[1] != -1)
                        {
                            where[1] = 1;
                        }
                        else
                        {
                            where[1] = 2;
                        }
                        
                    }
                    else
                    {
                        if(where[chars.length - 2] != 1)
                        {
                            where[chars.length - 2] = -1;
                        }
                        else
                        {
                            where[chars.length - 2] = 2;
                        }      
                    }
                }
            }
          
            if(where[0] == - 1)
            {
                chars[0] = '*';
            }
            else
            {
                chars[0] = 'M';
            }
            if(where[chars.length - 1] == 1)
            {
                chars[chars.length - 1] = '*';
            }
            else
            {
                chars[chars.length - 1] = 'B';
            }
            
            for(int k = 1; k < chars.length - 1; k++)
            {
                if(where[k] == -1)
                {
                    chars[k] = '<';
                }
                else if(where[k] == 1)
                {
                    chars[k] = '>';
                }
                else if(where[k] == 2)
                {
                    chars[k] = '#';
                }
                else
                {
                    chars[k] = '.';
                }
            }   
        }
        return result;
    }
}