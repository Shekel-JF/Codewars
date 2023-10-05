class Solution
{
    public static int sum;
    static int maxSum(TreeNode root)
    {
        sum = Integer.MIN_VALUE;
        if(root == null)
        {
            return 0;
        }
        maxSumHelper(root, 0);
        return sum;
    }
  
    static void maxSumHelper(TreeNode node, int curr)
    {
        if(node != null)
        {
            curr+=node.value;    
            if(node.left != null)
            {
                maxSumHelper(node.left, curr);
            }
            else if(node.right == null)
            {
                if(curr > sum)
                {
                    sum = curr;  
                }
            }          
        
            if(node.right != null)
            {
                maxSumHelper(node.right, curr);
            }
        }    
    }
}