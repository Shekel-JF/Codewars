import java.util.*;
public class LoopInspector
{
    public int loopSize(Node node)
    { 
        Map<Node, Integer> map = new HashMap<>();
        map.put(node, 0);
        int length = 1;
        while(!map.containsKey(node.getNext()))
        {
            map.put(node.getNext(), length);
            node = node.getNext();
            length++;         
        }
        return map.get(node) - map.get(node.getNext()) + 1;   
    }
}