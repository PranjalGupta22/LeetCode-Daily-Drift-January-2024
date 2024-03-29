----------PROBLEM STATEMENT----------

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Constraints:

The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].
 
----------EXAMPLES----------
  
Example 1:

Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:

Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 
----------JAVA SOLUTION----------

class Solution {
    public List<Integer> leaf(TreeNode root,List<Integer> ans){
        if(root == null) return ans;
        if(root.left == null && root.right == null) {
            ans.add(root.val);
        }
        leaf(root.left,ans);
        leaf(root.right,ans);
        return ans; 
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ans1 = new ArrayList<>();
        ans1 = leaf(root1,ans1);
        List<Integer> ans2 = new ArrayList<>();
        ans2 = leaf(root2,ans2);
        if(ans1.size()!=ans2.size()) return false;
        for(int i = 0;i<ans1.size();i++){
            if(ans1.get(i)!=ans2.get(i)) return false;
        }
        return true;
    }
}
