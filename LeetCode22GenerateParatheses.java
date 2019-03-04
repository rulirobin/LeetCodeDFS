package dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22GenerateParatheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n<=0) return res;
        findAllSolutions(0,0,n,new StringBuilder(), res);
        return res; 
    	
    }
    private void findAllSolutions(int left, int right, int total, StringBuilder path, List<String> res) {
    	if(left == total && right == total) {
    		res.add(path.toString());
    		return;
    	}
    	if(left > total || right > left || right > total) {
    		return;
    	}
    	// add left 
    	path.append("(");
    	findAllSolutions(left + 1, right, total, path, res);
    	path.setLength(path.length() - 1);
    	// add right
    	path.append(")");
    	findAllSolutions(left, right + 1, total, path, res);
    	path.setLength(path.length() - 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
