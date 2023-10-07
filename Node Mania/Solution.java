import java.util.*;
public class Solution
{
    public static Integer searchKFromEnd(Node node, int k)
    {
        if(node == null)
        {
            return null;
        }
           
        List<Node> nodes = new ArrayList<>();    
        Node point = new Node(0);
        point.next = node;    
      
        while(point.next!=null)
        {
            nodes.add(point.next);
            point = point.next;
        }
        if(k > nodes.size())
        {
            return null;
        }
        return nodes.get(nodes.size() - k).data;
    }
}