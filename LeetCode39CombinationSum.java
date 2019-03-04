package dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new ArrayList<>();
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
    	
//    	for(int i = index; i<candidates.length; i++) {
//    		path.add(candidates[i]);
//    		findAllSolutions(i, currSum + candidates[i], target, candidates, path, res);
//    		path.remove(path.size() - 1);
//    	}
    	// add 
    	path.add(candidates[index]);                  
    	findAllSolutions(index,currSum+candidates[index],target,candidates,path,res);
    	path.remove(path.size() - 1);
    	// do not add
    	findAllSolutions(index+1,currSum,target,candidates,path,res);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode39CombinationSum test =new LeetCode39CombinationSum();
		int[] candidates = {2,3,7};
		int target = 7;
		List<List<Integer>> res = test.combinationSum(candidates, target);
		for(List<Integer> list :res) {
			for(Integer num: list) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

}
