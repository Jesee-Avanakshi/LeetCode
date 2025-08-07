/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node =q.poll();
            if(node==null){
                res.append('N').append(',');
            }else{
                res.append(node.val).append(',');
                q.add(node.left);
                q.add(node.right);   
            }
            
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] list = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if(list[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            node.left = (list[i].equals("N"))?null: new TreeNode(Integer.parseInt(list[i]));
            node.right =(list[i+1].equals("N"))?null:new TreeNode(Integer.parseInt(list[i+1]));
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
            i+=2;
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));