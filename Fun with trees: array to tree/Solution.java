import java.util.*;
public class Solution
{  
    static TreeNode arrayToTree(int[] array)
    {
        if (array.length == 0)
        {
            return null;
        }
      
        Queue <TreeNode> queue = new LinkedList<>(); 
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
      
        int index = 1;
        while(index < array.length)
        {
            TreeNode curr = queue.poll();
            curr.left = new TreeNode(array[index++]);
            queue.offer(curr.left);
          
            if(index != array.length)
            {
                curr.right = new TreeNode(array[index++]);
                queue.offer(curr.right);
            }
        }
      
        return root;
    }
}