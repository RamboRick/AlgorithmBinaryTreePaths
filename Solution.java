package leetcode275;

import java.util.List;
import java.util.ArrayList;

/// 257. Binary Tree Paths
/// 时间复杂度: O(n), n为树中的节点个数
/// 空间复杂度: O(h), h为树的高度
public class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
    	ArrayList<String> result = new ArrayList<String>();
    	
    	if(root == null){
    		return result;
    	}
    	
    	if (root.left == null && root.right == null){
    		result.add(Integer.toString(root.val));
    		return result;
    	}
    	
    	List<String> leftPaths = binaryTreePaths(root.left);
    	for (String s : leftPaths){
    		StringBuilder sb = new StringBuilder(Integer.toString(root.val));
    		sb.append("->");
    		sb.append(s);
    		result.add(sb.toString());
    	}
    	
    	List<String> rightPaths = binaryTreePaths(root.right);
    	for (String s : rightPaths){
    		StringBuilder sb = new StringBuilder(Integer.toString(root.val));
    		sb.append("->");
    		sb.append(s);
    		result.add(sb.toString());
    	}
    	
    	return result;
    }
  }
