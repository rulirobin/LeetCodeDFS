package dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode282ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        findAllSolutions(0,0,target,num,new StringBuilder(), res);
        return res;
    }
    private void findAllSolutions(long sum, long lastVal, int target, String num, StringBuilder path, List<String> res){ 
    	if(num.length() == 0 && sum == target) {
    		res.add(path.toString());
    		return;
    	}
    	if(num.length() == 0) {
    		return;
    	}
    	long curr = 0;
    	int len = path.length();
    	for(int i = 0; i < num.length(); i++) {
    		curr = 10*curr + num.charAt(i) - '0';	
    		if(len == 0) {
    			path.append(curr);
    			findAllSolutions(sum+curr, curr,target,num.substring(i+ 1),path,res);
    			path.setLength(len);
    		}else {
    			// operation +
    			
    			path.append("+" + curr);
    			findAllSolutions(sum + curr, curr, target, num.substring(i+ 1), path, res);
    			path.setLength(len);
    			// operation -
    			path.append("-" + curr);
    			findAllSolutions(sum - curr, -curr, target, num.substring(i+ 1), path, res);
    			path.setLength(len);
    			// operation *
    			path.append("*" + curr);
    			findAllSolutions(sum - lastVal + lastVal * curr, lastVal * curr, target, num.substring(i+ 1), path, res);
    			path.setLength(len);
    		}
    		if(curr == 0) break;
    	}
    }
    	
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode282ExpressionAddOperators test = new LeetCode282ExpressionAddOperators();
		String num = "105";
		int target = 5;
		List<String> res = test.addOperators(num, target);
		for(String str : res) {
			System.out.println(str);
		}
	}

}
