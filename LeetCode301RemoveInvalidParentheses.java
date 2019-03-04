package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s){
    	List<String> res = new ArrayList<>();
    	if(s == null || s.length() == 0)return res;
    	int rmL = 0;
    	int rmR = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') {
    			rmL ++;
    		}
    		else if(s.charAt(i) == ')') {
    			if(rmL > 0) {
    				rmL --;
    			}else {
    				rmR ++;
    			}
    		}
    	}
    	Set<String> set = new HashSet<>();
    	findAllSolutions(rmL, rmR, 0, 0, new StringBuilder(), s, set);
    	for(String key : set) {
    		res.add(key);
    	}
    	return res;
    }
    private void findAllSolutions(int rmL, int rmR, int diff, int index, StringBuilder path, String s, Set<String> res) {
    	if(rmL == 0 && rmR == 0 && diff == 0 && index == s.length()) {
    		res.add(path.toString());
    		return;
    	}
    	if(rmL < 0 || rmR < 0 || diff < 0 || index >= s.length()) {
    		return;
    	}
    	
		int len = path.length();
		if(s.charAt(index) =='(') {
			// add (
			path.append("(");
			findAllSolutions(rmL, rmR, diff + 1, index+1, path,s,res);
			path.setLength(len);
			// do not add
			findAllSolutions(rmL - 1, rmR, diff, index + 1, path, s ,res);
		}else if(s.charAt(index) == ')') {
			// add )
			path.append(")");
			findAllSolutions(rmL, rmR, diff - 1, index+1, path,s,res);
			path.setLength(len);
			// do not add 
			findAllSolutions(rmL, rmR - 1, diff, index + 1, path, s ,res);
		}else {
			path.append(s.charAt(index));
		}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode301RemoveInvalidParentheses test = new LeetCode301RemoveInvalidParentheses();
		List<String> res = test.removeInvalidParentheses("())");
		for(String str: res) {
			System.out.println(str);
		}
	}

}
