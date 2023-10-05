public class TreeNode
{
    TreeNode left;
    TreeNode right;

    public static boolean isPerfect(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        int depth = 0;
        TreeNode node = root;
      
        while(node.left != null)
        {
            depth++;
            node = node.left;
        }        
        return isPerfect(root, 0, depth);
    }
    static boolean isPerfect(TreeNode node, int level, int depth)
    {   
        if(node.left != null && node.right == null || node.left == null && node.right != null)
        {
            return false;
        }
        if(node.left == null && node.right == null)
        {
            return level == depth;
        }
      
        return isPerfect(node.left, level + 1, depth) && isPerfect(node.right, level + 1, depth);
    }
    
    static TreeNode leaf()
    {
        return new TreeNode();
    }

    static TreeNode join(TreeNode left, TreeNode right)
    {
        return new TreeNode().withChildren(left, right);
    }

    TreeNode withLeft(TreeNode left)
    {
        this.left = left;
        return this;
    }

    TreeNode withRight(TreeNode right)
    {
        this.right = right;
        return this;
    }

    TreeNode withChildren(TreeNode left, TreeNode right)
    {
        this.left = left;
        this.right = right;
        return this;
    }

    TreeNode withLeftLeaf()
    {
        return withLeft(leaf());
    }

    TreeNode withRightLeaf()
    {
        return withRight(leaf());
    }

    TreeNode withLeaves()
    {
        return withChildren(leaf(), leaf());
    }
}