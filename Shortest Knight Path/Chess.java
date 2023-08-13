import java.util.*;
import java.awt.Point;
public class Chess
{
    public static int knight(String start, String finish)
    {
        int[][] board = new int[8][8];  
        int posX = start.charAt(0) - 97;
        int posY = start.charAt(1) - 49;   
        int finX = finish.charAt(0) - 97;
        int finY = finish.charAt(1) - 49;
        
        return visit(posX, posY, board, finX, finY);
    }
  
    public static int visit(int x, int y, int[][] board, int finX, int finY)
    {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        
        while(!queue.isEmpty())
        {      
            Point curr = queue.poll();
            int i = (int)curr.getX();
            int j = (int)curr.getY();
            if(i == finX && j == finY)
            {
                return board[i][j];
            }      

            if(i + 2 < 8 && j + 1 < 8 && board[i + 2][j + 1] == 0)
            {
                board[i + 2][j + 1] = board[i][j] + 1;
                queue.add(new Point(i + 2, j + 1));
            }

            if(i - 2 >= 0 && j + 1 < 8 && board[i - 2][j + 1] == 0)
            {
                board[i - 2][j + 1] = board[i][j] + 1;
                queue.add(new Point(i - 2, j + 1));
            }

            if(i + 2 < 8 && j - 1 >= 0 && board[i + 2][j - 1] == 0)
            {
                board[i + 2][j - 1] = board[i][j] + 1;
                queue.add(new Point(i + 2, j - 1));
            }

            if(i - 2 >= 0 && j - 1 >= 0 && board[i - 2][j - 1] == 0)
            {
                board[i - 2][j - 1] = board[i][j] + 1;
                queue.add(new Point(i - 2, j - 1));
            }

            if(i - 1 >= 0 && j + 2 < 8 && board[i - 1][j + 2] == 0)
            {
                board[i - 1][j + 2] = board[i][j] + 1;
                queue.add(new Point(i - 1, j + 2));
            }

            if(i + 1 < 8 && j + 2 < 8 && board[i + 1][j + 2] == 0)
            {
                board[i + 1][j + 2] = board[i][j] + 1;
                queue.add(new Point(i + 1, j + 2));
            }

            if(i - 1 >= 0 && j - 2 >=0 && board[i - 1][j - 2] == 0)
            {
                board[i - 1][j - 2] = board[i][j] + 1;
                queue.add(new Point(i - 1, j - 2));
            }

            if(i + 1 < 8 && j - 2 >= 0 && board[i + 1][j - 2] == 0)
            {
                board[i + 1][j - 2] = board[i][j] + 1;
                queue.add(new Point(i + 1, j - 2));
            }
        }
        return board[finX][finY];
    } 
}