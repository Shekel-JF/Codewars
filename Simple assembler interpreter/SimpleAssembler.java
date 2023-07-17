import java.util.*;

public class SimpleAssembler
{
    public static Map<String, Integer> interpret(String[] program)
    {
        Map<String, Integer> map = new HashMap<>();
        for (int a = 0; a < program.length; a++)
        {

            String[] commands = program[a].split(" ");
            if (commands.length > 2)
            {
                if (commands[2].charAt(0) > 96 && commands[2].charAt(0) < 123)
                {
                    commands[2] = String.valueOf(map.get(commands[2]));
                }
            }

            if (commands[0].equals("mov"))
            {
                map.put(commands[1], Integer.parseInt(commands[2]));
            }
            else if (commands[0].equals("inc"))
            {
                Integer value = map.get(commands[1]);
                if (value != null)
                {
                    map.put(commands[1], value + 1);
                }
            }
            else if (commands[0].equals("dec"))
            {
                Integer value = map.get(commands[1]);
                if (value != null)
                {
                    map.put(commands[1], value - 1);
                }
            }
            else if (commands[0].equals("jnz"))
            {
                Integer value = map.get(commands[1]);
                if (value != null && value != 0 && a + Integer.parseInt(commands[2]) >= 0)
                {
                    a = a + Integer.parseInt(commands[2]) - 1;
                }
            }
        }
        Map<String, Integer> mapa = map;

        return mapa;
    }
}
