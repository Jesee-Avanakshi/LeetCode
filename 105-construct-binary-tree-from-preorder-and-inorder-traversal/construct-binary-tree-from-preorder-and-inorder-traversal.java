/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode build(int[] preorder,int preStart, int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart>preEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inroot = inMap.get(root.val);
        int numsLeft = inroot-inStart;

        root.left = build(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inroot-1,inMap);
        root.right = build(preorder,preStart+numsLeft+1,preEnd,inorder,inroot+1,inEnd,inMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        int preStart =0,preEnd=preorder.length-1,inStart=0,inEnd=inorder.length-1;

        TreeNode root = build(preorder,preStart,preEnd,inorder,inStart,inEnd,inMap);
        return root;

    }
}