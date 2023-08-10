class Solution
{
	public static String rangeExtraction(int[] arr)
    {
        StringBuilder result = new StringBuilder();
        result.append(arr[0]);
        for(int i = 0; i < arr.length - 1; i++)
        {
            if(arr[i + 1] - arr[i] > 1 || i + 2 < arr.length && arr[i + 2] - arr[i + 1] > 1 || i + 2 >= arr.length)
            {
                result.append(",").append(arr[i + 1]);
            }
            else
            {
                while(i < arr.length - 1 && arr[i + 1] - arr[i] == 1)
                {
                    i++;
                }
                result.append("-").append(arr[i]);
                i--;
            }
        }  
    	return result.toString();
    }
}