import java.util.*;
public class Spiralizor
{
    public static int[][] spiralize(int size)
    {
        int[][] spiral = new int[size][size];   
        for(int i = 0; i < size; i++)
        {
            Arrays.fill(spiral[i], 0);
        }
   
      
        int topRow = 0;
        int leftCol = 0;
        int botRow = size - 1;
        int rightCol = size - 1;
      
        while(topRow <= botRow)
        {
            for(int i = leftCol; i <= rightCol; i++)
            {
                spiral[topRow][i] = 1;
            }                 
          
            for(int i = topRow; i <= botRow; i++)
            {
                spiral[i][rightCol] = 1;
            }     
          
            if(leftCol != 0)
            {
                leftCol++;
            }
            if(botRow == topRow + 1)
            {
                break;
            }
                
            for(int i = leftCol; i < rightCol; i++)
            {
                spiral[botRow][i] = 1;
            }     
          
            topRow+=2;
            for(int i = topRow; i < botRow; i++)
            {
                spiral[i][leftCol] = 1;
            }
          
            botRow-=2;       
            leftCol++;
            rightCol-=2;
        }
        return spiral;
    }
}