public class LinkedListPairs
{
    public static Node swapPairs(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
      
        Node point = new Node("head");
        point.next = head;    
        Node prev = point;
      
        while(head!=null && head.next != null)
        {
            prev.next = head.next;
            head.next = head.next.next;
            prev.next.next = head;

            prev = head;
            head = head.next;
        }      
        return point.next;
    }
}