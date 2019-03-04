package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LeetCode40CombinationSumTwo {
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(candidates);
    	if(candidates == null ||candidates.length == 0) return res;
    	findAllSolutions(0,0,target,candidates,new ArrayList<>(), res);
    	return res;
    }
    private void findAllSolutions(int index, int currSum, int target,  int[] candidates,List<Integer> path, List<List<Integer>> res) {
    	if(currSum == target) {
    		res.add(new ArrayList<>(path));
    		return;
    	}
    	if(index >= candidates.length ||currSum > target) {
    		return;
    	}
    	for(int i = index; i<candidates.length; i++) {
    		path.add(candidates[i]);
    		findAllSolutions(i + 1, currSum + candidates[i], target, candidates, path, res);
    		path.remove(path.size() - 1);
    		while(i + 1< candidates.length && candidates[i+1] == candidates[i]) {
    			i++;
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode40CombinationSumTwo test =new LeetCode40CombinationSumTwo();
		int[] candidates = {3,1,3,5,1,1};
		int target = 8;
		List<List<Integer>> res = test.combinationSum(candidates, target);
		for(List<Integer> list :res) {
			for(Integer num: list) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

}
