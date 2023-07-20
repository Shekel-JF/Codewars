public class CarMileage
{
  public static int isInteresting(int number, int[] awesomePhrases)
  {
      System.out.println(number);
      int tmp = number;
      int returnValue = 2;
      while(number <= tmp + 2)
      {   
          if(number > 99)
          {
              for(int i : awesomePhrases)
              {
                  if (number == i)
                  {
                      return returnValue;
                  }
              }
               
              char[] digits = Integer.toString(number).toCharArray(); 
              for(int a = 1; a < digits.length; a++)
              {
                  if(digits[a]!='0')
                  {
                      break;
                  }
                  else if(a == digits.length - 1)
                  {
                      return returnValue;
                  }
              }
        
              for(int a = 1; a < digits.length; a++)
              {
                  if(digits[a] != digits[0])
                  {
                      break;
                  }
                  else if(a == digits.length - 1)
                  {
                      return returnValue;
                  }
              }
        
              for(int a = 0; a < digits.length - 1; a++)
              {
                  System.out.println(digits[a]);
                  if(digits[a] != digits[a + 1] - 1 && !(digits[a] == '9' && digits[a + 1] == '0'))
                  {
                      break;
                  }
                  else if(a == digits.length - 2)
                  {
                      return returnValue;
                  }
              }
        
              for(int a = 0; a < digits.length - 1; a++)
              {
                  System.out.println(digits[a]);
                  if(digits[a] != digits[a + 1] + 1)
                  {
                      break;
                  }
                  else if(a == digits.length - 2)
                  {
                      return returnValue;
                  }
              }
        
              for(int a = 0; a <= digits.length / 2; a++)
              {
                  if(digits[a] != digits[digits.length - 1 - a])
                  {
                      break;
                  }
                  else if(a == digits.length / 2)
                  {
                      return returnValue;
                  }
              }
          }
          returnValue = 1;
          number++;        
      }
      return 0;   
  }
}