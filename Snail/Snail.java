import java.util.ArrayList;

public class Snail
{
    public static int[] snail(int[][] array)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int n = array.length;
        int m = array[0].length;
        int row = 0, col = 0;

        while (row < n && col < m)
        {
            for (int i = col; i < m; i++)
            {
                res.add(array[row][i]);
            }
            row++;

            for (int i = row; i < n; i++)
            {
                res.add(array[i][m-1]);
            }
            m--;

            if (row < n)
            {
                for (int i = m-1; i >= col; i--)
                {
                    res.add(array[n-1][i]);
                }
                n--;
            }

            if (col < m)
            {
                for (int i = n-1; i >= row; i--)
                {
                    res.add(array[i][col]);
                }
                col++;
            }
        }

        int[] arr = res.stream().mapToInt(i -> i).toArray();
        return arr;
    }
}