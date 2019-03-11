import java.util.HashMap;

public class LeetCode403FrogJump {
    public boolean canCross(int[] stones) {
        if(stones == null ||stones.length <=1) return false;
        if(stones[1] - stones[0] != 1) return false;
        HashMap<Integer, Boolean>[] mem = new HashMap[stones.length];
        for(int i = 0; i < stones.length; i++) {
        	mem[i] = new HashMap<>();
        }
        return findIfFrogCanJump(1,1,stones, mem);
        // DP TODO

    }
    private boolean findIfFrogCanJump(int index, int k, int[] stones, HashMap<Integer, Boolean>[] mem) {
    	if(index == stones.length - 1) return true;
    	if(mem[index].containsKey(k)) return mem[index].get(k);
    	for(int i = index + 1; i < stones.length; i++) {
    		int distance = stones[i] - stones[index]; 
    		// instead of list k -1 ,k , k + 1, calculate if the distance between i to index is in the range of k - 1 to k + 1 is a better idea
    		if(distance <k - 1) continue;
    		if(distance >k +1 ) break;
    		if(findIfFrogCanJump(i, distance, stones, mem)) {
    			mem[index].put(k, true);
    			return true;
    		}
    	}
    	mem[index].put(k, false);
    	return false;
    }
	public static void main(String[] args) {
		LeetCode403FrogJump test = new LeetCode403FrogJump();
		int[] stones = {0,1,3,5,6,8,12,17};
		int[] stones1 = {0,1,2,3,4,8,9,11};
		System.out.println(test.canCross(stones));
		System.out.println(test.canCross(stones1));
		// TODO Auto-generated method stub

	}

}
