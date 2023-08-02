import java.util.*;

public class ConnectFour
{
    public static String whoIsWinner(List<String> piecesPositionList)
    {
        char[][] table = new char[7][6];
        for(String s : piecesPositionList)
        {
            int n = 5;
            while(true)
            {
                if(table[s.charAt(0) - 65][n] == '\u0000')
                {
                    table[s.charAt(0) - 65][n] = s.charAt(2);
                    break;
                }
                else
                {
                    n--;
                }
            }
            for(int i = 0; i < 7; i++)
            {
                for(int j = 0; j < 6; j++)
                {
                    if((j + 3 < 6 && table[i][j] == 'R' && table[i][j+1] == 'R' && table[i][j+2] == 'R' && table[i][j + 3] == 'R') ||
                    (i + 3 < 7 && table[i][j] == 'R' && table[i + 1][j] == 'R' && table[i + 2][j] == 'R' && table[i + 3][j] == 'R') ||
                    (i + 3 < 7 && j + 3 < 6 && table[i][j] == 'R' && table[i + 1][j + 1] == 'R' && table[i + 2][j + 2] == 'R' && table[i + 3][j + 3] == 'R') ||
                    (i + 3 < 7 && j - 3 >= 0 && table[i][j] == 'R' && table[i + 1][j - 1] == 'R' && table[i + 2][j - 2] == 'R' && table[i + 3][j - 3] == 'R'))
                    {
                        return "Red";
                    }
                    else if((j + 3 < 6 && table[i][j] == 'Y' && table[i][j+1] == 'Y' && table[i][j+2] == 'Y' && table[i][j + 3] == 'Y') ||
                    (i + 3 < 7 && table[i][j] == 'Y' && table[i + 1][j] == 'Y' && table[i + 2][j] == 'Y' && table[i + 3][j] == 'Y') ||
                    (i + 3 < 7 && j + 3 < 6 && table[i][j] == 'Y' && table[i + 1][j + 1] == 'Y' && table[i + 2][j + 2] == 'Y' && table[i + 3][j + 3] == 'Y') ||
                    (i + 3 < 7 && j - 3 >= 0 && table[i][j] == 'Y' && table[i + 1][j - 1] == 'Y' && table[i + 2][j - 2] == 'Y' && table[i + 3][j - 3] == 'Y'))
                    {
                        return "Yellow";
                    }                   
                }
            }
        }    
        return "Draw";
    }
}