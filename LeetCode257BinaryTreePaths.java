package dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode257BinaryTreePaths {
	private class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
		
	}
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<>();
    	if(root == null ) return res;
    	findAllPaths(root,new StringBuilder(), res);
    	return res;
    }
    private void findAllPaths(TreeNode node, StringBuilder path, List<String> res) {
    	if(node == null) {
    		return;
    	}
    	if(node.left == null && node.right == null) {
    		path.append(node.val);
    		res.add(path.toString());
    		path.setLength(path.length() -1);
    		return;
    	}
    	int len = path.length();
    	//left
    	path.append(node.val + "->");
    	findAllPaths(node.left, path, res);
    	path.setLength(len);
    	//right
    	path.append(node.val + "->");
    	findAllPaths(node.right, path,res);
    	path.setLength(len);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
