import java.util.*;

public class ObservedPin
{
    public static List<String> getPINs(String observed)
    {
        int num = 1;
        int[][] numbers = new int[3][3];
        for(int a = 0; a < 3; a++)
        {
            for(int b = 0; b < 3; b++)
            {
                numbers[a][b] = num;
                num++;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int a = 0; a < 3; a++)
        {
            for(int b = 0; b < 3; b++)
            {
                List<Integer> possibleNum = new ArrayList<>();
                possibleNum.add(numbers[a][b]);
                if(a - 1 >= 0)
                {
                    possibleNum.add(numbers[a - 1][b]);
                }
                if(a + 1 < 3)
                {
                    possibleNum.add(numbers[a + 1][b]);
                }
                if(b - 1 >= 0)
                {
                    possibleNum.add(numbers[a][b - 1]);
                }                
                if(b + 1 < 3)
                {
                    possibleNum.add(numbers[a][b + 1]);
                } 
                map.put(numbers[a][b], possibleNum);
            }
        }
        List<Integer> possibleNum = new ArrayList<>();
        possibleNum.add(8);
        possibleNum.add(0);
        map.put(0, possibleNum);
      
        List<Integer> update = map.get(8);
        update.add(0);
        map.put(8, update);
      
        List<String> codes = new ArrayList<>();
        char[] obsNum = observed.toCharArray();
        
        for(char c : obsNum)
        {
            int digit = Character.getNumericValue(c);
            List<Integer> possibleDigits = map.get(digit);
            List<String> tempCodes = new ArrayList<>();
          
            if(codes.isEmpty())
            {
                for(Integer possibleDigit : possibleDigits)
                {
                    tempCodes.add(possibleDigit.toString());
                }
            }
            else
            {
                for(String code : codes)
                {
                    for(Integer possibleDigit : possibleDigits)
                    {
                        tempCodes.add(code + possibleDigit.toString());
                    }
                }
            }
            codes = tempCodes;
        }
        return codes;
    }        
}