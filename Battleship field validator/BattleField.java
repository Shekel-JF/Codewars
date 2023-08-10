import java.util.*;
public class BattleField
{    
    public static boolean fieldValidator(int[][] field)
    {
        int battleship = 1;
        int cruiser = 2;
        int destroyer = 3;
        int submarine = 4;
        
        List<String> ships = new ArrayList<>();
        for(int i = 0; i < field.length; i++)
        {
            StringBuilder ship1 = new StringBuilder();
            StringBuilder ship2 = new StringBuilder();
            for(int j = 0; j < field[0].length; j++)
            {
                ship1.append(Integer.toString(field[i][j]));
                ship2.append(Integer.toString(field[j][i]));
                if(field[i][j] == 1)
                {
                    if((i + 1 >= field.length || field[i + 1][j] == 0) &&
                    (j + 1 >= field[0].length || field[i][j + 1] == 0) &&
                    (i - 1 < 0 || field[i - 1][j] == 0) &&
                    (j - 1 < 0 || field[i][j - 1] == 0))
                    {
                        submarine--;
                    }
                    if((i + 1 < field.length && j + 1 < field[0].length && field[i + 1][j + 1] == 1) ||
                    (i + 1 < field.length && j - 1 >= 0 && field[i + 1][j - 1] == 1) ||
                    (i - 1 >= 0 && j - 1 >= 0 && field[i - 1][j - 1] == 1) ||
                    (i - 1 >= 0 && j + 1 < field[0].length && field[i - 1][j + 1] == 1))
                    {
                        return false;
                    }
                }
            }
            ships.add(ship1.toString());
            ships.add(ship2.toString());       
        }
      
        for(String s : ships)
        {
            char iterate[] = s.toCharArray();
            int count = 0;
            for(int k = 0; k < iterate.length; k++)
            {              
                if(iterate[k] == '1')
                {
                    count++;
                }
                if(iterate[k] == '0' || k == iterate.length - 1)
                {
                    if(count == 4)
                    {
                        battleship--;
                    }
                    else if(count == 3)
                    {
                        cruiser--;
                    }
                    else if(count == 2)
                    {
                        destroyer--;
                    }
                    count = 0;
                }
            }
        }
        if(battleship == 0 && cruiser == 0 && destroyer == 0 && submarine == 0)
        {
            return true;
        }
        return false;    
    }
}