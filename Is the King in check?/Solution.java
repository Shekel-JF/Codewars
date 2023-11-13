public class Solution
{
    public static boolean pawnCheck(int x, int y, char[][] board)
    {
        if(x - 1 >= 0 &&
          (y - 1 >= 0 && board[x - 1][y - 1] == 'P' ||
           y + 1 < 8 && board[x - 1][y + 1] == 'P'))
        {
            return true;
        }
        return false;
    }
    public static boolean rookCheck(int x, int y, char[][] board, char piece)
    {
        int tmpX = x;
        int tmpY = y;

        while(x + 1 < 8 && board[x + 1][y] == ' ')
        {
            x++;
        }
        if(x + 1 != 8 && board[x + 1][y] == piece)
        {
            return true;
        }   
        x = tmpX;
      
        while(x - 1 > 0 && board[x - 1][y] == ' ')
        {
            x--;
        }
        if(x != 0 && board[x - 1][y] == piece)
        {
            return true;
        }
        x = tmpX;
      
        while(y + 1 < 8 && board[x][y + 1] == ' ')
        {
            y++;
        }
        if(y + 1 != 8 && board[x][y + 1] == piece)
        {
            return true;
        }
        y = tmpY;
        
        while(y - 1 > 0 && board[x][y - 1] == ' ')
        {
            y--;
        }
        if(y != 0 && board[x][y - 1] == piece)
        {
            return true;
        }        
        
        return false;
    }
  
    public static boolean knightCheck(int x, int y, char[][] board)
    {
        if(x + 2 < 8 && (y + 1 < 8 && board[x + 2][y + 1] == 'N' ||
                         y - 1 >= 0 && board[x + 2][y - 1] == 'N')||
           x - 2 >= 0 && (y + 1 < 8 && board[x - 2][y + 1] == 'N' || 
                         y - 1 >= 0 && board[x - 2][y - 1] == 'N')||
           y + 2 < 8 && (x + 1 < 8 && board[x + 1][y + 2] == 'N' ||
                         x - 1 >= 0 && board[x - 1][y + 2] == 'N')||
           y - 2 >= 0 && (x + 1 < 8 && board[x + 1][y - 2] == 'N' || 
                         x - 1 >= 0 && board[x - 1][y - 2] == 'N'))
        {
            return true;  
        }
      
        return false;
    }
  
    public static boolean bishopCheck(int x, int y, char[][] board, char piece)
    {
        int tmpX = x;
        int tmpY = y;

        while(x + 1 < 8 && y + 1 < 8 && board[x + 1][y + 1] == ' ')
        {
            x++;
            y++;
        }
        if(x + 1 != 8 && y + 1 != 8 && board[x + 1][y + 1] == piece)
        {
            return true;
        }   
        x = tmpX;
        y = tmpY;
      
        while(x - 1 > 0 && y - 1 > 0 && board[x - 1][y - 1] == ' ')
        {
            x--;
            y--;
        }
        if(x != 0 && y != 0 && board[x - 1][y - 1] == piece)
        {
            return true;
        }
        x = tmpX;
        y = tmpY;
      
        while(y + 1 < 8 && x - 1 > 0 && board[x - 1][y + 1] == ' ')
        {
            x--;
            y++;
        }
        if(y + 1 != 8 && x != 0 && board[x - 1][y + 1] == piece)
        {
            return true;
        }
        x = tmpX;
        y = tmpY;
        
        while(y - 1 > 0 && x + 1 < 8 && board[x + 1][y - 1] == ' ')
        {
            x++;
            y--;
        }
        if(y != 0 && x + 1 < 8 && board[x + 1][y - 1] == piece)
        {
            return true;
        }        
        
        return false;
    }
  
  
    public static boolean isTheKinginCheck(char[][] chessboard)
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(chessboard[i][j] == 'K')
                {
                    if(pawnCheck(i, j, chessboard) ||
                       rookCheck(i, j, chessboard, 'R') ||
                       rookCheck(i, j, chessboard, 'Q') ||
                       knightCheck(i, j, chessboard) ||
                       bishopCheck(i, j, chessboard, 'B') ||
                       bishopCheck(i, j, chessboard, 'Q'))
                    {
                        return true;
                    }
                    break;
                }          
            }  
        }
        return false;
    }
}