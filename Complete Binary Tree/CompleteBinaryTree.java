import java.util.function.Function;

public class CompleteBinaryTree implements Function<int[], int[]>
{
    private int[] result;
    private int index;
    
    @Override
    public int[] apply(int[] input)
    {
        index = 0;
        result = new int[input.length];

        inOrder(0, input);
        return result;
    }
    private void inOrder(int resultIndex, int[] input){
        if (resultIndex >= input.length)
        {
            return;
        }
        inOrder(resultIndex * 2 + 1, input);
        result[resultIndex] = input[index];
        index++;
        inOrder(resultIndex * 2 + 2, input);
    }
}