populating-next-right-pointers-in-each-node

//Time complexity: O(N)
//Space complexity : O(1)


public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) { return; }
        for (TreeLinkNode head=root; head.left!=null; head=head.left) {
            for (TreeLinkNode parent=head; parent!=null; parent=parent.next) {
                parent.left.next = parent.right;
                if (parent.next != null) { parent.right.next = parent.next.left; }
            }
        }
    }
}




Recover Binary Search Tree 
//Time complexity :O(N)
//Space complexity: O(1)



public class Solution {
    
     TreeNode first = null, second = null, pre = null;
    public void recoverTree(TreeNode root) {
        if(root==null)return;
        dfs(root);
        if(first!=null&&second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        
    }
    public void  dfs(TreeNode root){
        if(root.left!=null)dfs(root.left);
        if(pre!=null&&pre.val>root.val)
            {
                if(first==null) first = pre;
                if(first!=null)second = root;
            }
        pre = root;
        if(root.right!=null)dfs(root.right);
    }
}
