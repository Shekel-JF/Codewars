import java.util.*;
import java.awt.Point;

class Canvas
{
    private char[][] array;
    private Queue<Point> queue;
    public Canvas(int width, int height) throws IllegalArgumentException
    {
        if (width < 1 || height < 1)
        {
            throw new IllegalArgumentException();
        }
        width += 2;
        height += 2;
        array = new char[height][width];
        for (int a = 0; a < height; a++)
        {
            for (int b = 0; b < width; b++)
            {
                if (a == 0 || a == height - 1)
                {
                    array[a][b] = '-';
                }
                else if (b == 0 || b == width - 1)
                {
                    array[a][b] = '|';
                }
                else
                {
                    array[a][b] = ' ';
                }
            }
        }
    }

    public Canvas draw(int x1, int y1, int x2, int y2)
    {
        x1++; x2++; y1++; y2++;
        if (x1 > x2)
        {
            int tmp = x2;
            x2 = x1;
            x1 = tmp;
        }
        if (y1 > y2)
        {
            int tmp = y2;
            y2 = y1;
            y1 = tmp;
        }
        if (x1 < 1 || x2 >= array[0].length - 1 || y1 < 1 || y2 >= array.length - 1)
        {
            throw new IllegalArgumentException();
        }

        for (int a = y1; a <= y2; a++)
        {
            array[a][x1] = 'x';
            array[a][x2] = 'x';
        }
        for (int b = x1; b <= x2; b++)
        {
            array[y1][b] = 'x';
            array[y2][b] = 'x';
        }
        return this;
    }

    public Canvas fill(int x, int y, char ch) throws IllegalArgumentException
    {
        x++; y++;
        if (x < 1 || y < 1 || x >= array[0].length - 1 || y >= array.length - 1)
        {
            throw new IllegalArgumentException();
        }
        //char toFill = array[x][y];
        char toFill = ' ';
        queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty())
        {
            Point current = queue.poll();
            int i = (int) current.getY();
            int j = (int) current.getX();
            if (array[i][j] != toFill)
            {
                continue;
            }
            array[i][j] = ch;

            if (i + 1 < array.length - 1 && array[i + 1][j] == toFill)
            {
                queue.add(new Point(j, i + 1));
            }
            if (i - 1 > 0 && array[i - 1][j] == toFill)
            {
                queue.add(new Point(j, i - 1));
            }
            if (j + 1 < array[0].length - 1 && array[i][j + 1] == toFill)
            {
                queue.add(new Point(j + 1, i));
            }
            if (j - 1 > 0 && array[i][j - 1] == toFill)
            {
                queue.add(new Point(j - 1, i));
            }
        }
        return this;
    }

    public String drawCanvas()
    {
        StringBuilder result = new StringBuilder();
        for (int a = 0; a < array.length; a++)
        {
            for (int b = 0; b < array[0].length; b++)
            {
                result.append(array[a][b]);
            }
            if (a != array.length - 1)
            {
                result.append("\n");
            }
        }
        return result.toString();
    }
}