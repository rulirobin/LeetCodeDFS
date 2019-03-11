import java.util.HashSet;
import java.util.Set;

public class LeetCode464CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	// use int map to mark if the number is used or not 
    	if(desiredTotal < 0) return false;
    	int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
    	if(sum < desiredTotal) return false;
    	int map = (1 << maxChoosableInteger) - 1;
    	Boolean[] mem = new Boolean[map + 1];
        return findAllSolutions(maxChoosableInteger, 0, desiredTotal, map, mem);
    }
    private boolean findAllSolutions(int max, int sum, int total, int map, Boolean[] mem) {
    	// for the number from 1 to max, the curr number could be chosed by current player or not.
    	// use for loop to realize the options. 
    	// only after searching all the options and did not return true. then the final answer is false
    	if(mem[map] != null) return mem[map];
    	for(int i = 1; i<= max; i++) {
    		// bit operation to mark the number is used 
    		int mask = 1 << (i - 1);
    		if((mask & map) != 0) {
    			if(sum + i>= total) {
    				return true;
    			}
    			int newMap = map - mask;
    			boolean res = findAllSolutions(max, sum + i, total,newMap, mem);
    			if(!res) {
    				mem[map] = true;
    				return true;
    			}
    		}
    		
    	}
    	mem[map] = false;
    	return false;
    }
	public static void main(String[] args) {
		
		LeetCode464CanIWin test = new LeetCode464CanIWin();
		System.out.println(test.canIWin(4, 6));
		System.out.println(test.canIWin(10,0));
		// TODO Auto-generated method stub

	}

}
