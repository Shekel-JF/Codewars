import java.util.*;
import java.awt.Point;

public class Finder
{
    static void calculate(int i, int j, int[][] t, int[][] paths, String[][] dir)
    {
        if (dir[i][j] == null)
        {
            dir[i][j] = "";
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        while(!queue.isEmpty())
        {
            Point current = queue.poll();
            i = (int)current.getX();
            j = (int)current.getY();
          
            if(i + 1 < t.length && paths[i][j] + t[i + 1][j] < paths[i + 1][j])
            {
                paths[i + 1][j] = paths[i][j] + t[i + 1][j];
                dir[i + 1][j] = dir[i][j] + "s";
                queue.add(new Point(i + 1, j));
            }
            if(i - 1 >= 0 && paths[i][j] + t[i - 1][j] < paths[i - 1][j])
            {
                paths[i - 1][j] = paths[i][j] + t[i - 1][j];
                dir[i - 1][j] = dir[i][j] + "n";
                queue.add(new Point(i - 1, j));
            }
            if(j + 1 < t[i].length && paths[i][j] + t[i][j + 1] < paths[i][j + 1])
            {
                paths[i][j + 1] = paths[i][j] + t[i][j + 1];
                dir[i][j + 1] = dir[i][j] + "e";
                queue.add(new Point(i, j + 1));
            }
            if(j - 1 >= 0 && paths[i][j] + t[i][j - 1] < paths[i][j - 1])
            {
                paths[i][j - 1] = paths[i][j] + t[i][j - 1];
                dir[i][j - 1] = dir[i][j] + "w";
                queue.add(new Point(i, j - 1));
            }
        }
    }
  
    static List<String> cheapestPath(int[][] t, Point start, Point finish)
    {
        int[][] paths = new int[t.length][t[0].length];
        String[][] dir = new String[t.length][t[0].length];
        for (int[] row : paths)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        paths[(int)start.getX()][(int)start.getY()] = t[(int)start.getX()][(int)start.getY()];
        calculate((int)start.getX(), (int)start.getY(), t, paths, dir);
        char[] array = dir[(int)finish.getX()][(int)finish.getY()].toCharArray();
        List<String> result = new ArrayList<>();
      
        for(int n = 0; n < array.length; n++)
        {
            switch(array[n])
            {
                case 'w':
                  result.add("left");
                  break;   
            
                case 'e':
                  result.add("right");
                  break;
                
                case 'n':
                  result.add("up");
                  break;
                
                case 's':
                  result.add("down");
                  break;
            }  
        }
        return result;
    }
}