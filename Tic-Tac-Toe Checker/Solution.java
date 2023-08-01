public class Solution
{
    public static int isSolved(int[][] board)
    {
        if((board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[1][1] != 0)
        {
            return board[1][1];
        }      
        for(int i = 0; i < 3; i++)
        {
            if(board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            {
                return board[i][0];
            }
            else if(board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i])
            {
                return board[0][i];
            }
        }
        for(int j = 0; j < 3; j++)
        {
            for(int k = 0; k < 3; k++)
            {
                if(board[j][k] == 0)
                {
                    return -1;
                }
            }
        }
        return 0;      
    }
}