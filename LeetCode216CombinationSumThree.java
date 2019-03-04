package dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=0 || k<=0) return res;
        findAllCombinations(1,k,0,n,new ArrayList<>(), res);
        return res;
    }
    private void findAllCombinations(int currVal, int num, int sum, int target,List<Integer> path, List<List<Integer>> res ) {
    	if(num == 0 && sum == target) {
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	if(num < 0 || sum > target) return;
    	
    	for(int i = currVal; i <=9; i++) {
    		path.add(i);
    		findAllCombinations(i+1, num -1 , sum + i, target, path, res);
    		path.remove(path.size()- 1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode216CombinationSumThree test = new LeetCode216CombinationSumThree();
		List<List<Integer>> res = test.combinationSum3(3, 9);
		for(List<Integer> list : res) {
			for(Integer num: list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
