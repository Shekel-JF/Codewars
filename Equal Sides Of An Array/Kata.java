public class Kata {
  public static int findEvenIndex(int[] arr)
  {
      int sum = 0;
      int tmp = 0;
      int index = 0;
      for(int a : arr)
      {
          sum+= a;
      }
      while(sum - tmp - arr[index] != tmp)
      {
          tmp = 0;
          index++;
          if(index < arr.length)
          {
              for(int i = 0; i < index; i++)
              {
                  tmp+=arr[i]; 
              }
          }
          else
          {
              return -1;
          }
      }
      return index;
  }
}