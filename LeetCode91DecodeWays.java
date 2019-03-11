import java.util.Arrays;

public class LeetCode91DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] mem = new int[s.length() + 1];
        Arrays.fill(mem, -1);
        return findAllSolutions(0,s, mem);
    }
    private int findAllSolutions(int index, String s, int[] mem) {
    	if(index == s.length()) {
    		return 1;
    	}
    	if(mem[index] != -1) return mem[index];
    	int size = 0;
    	for(int i = index + 1; i <= s.length(); i++) {
    		int val= Integer.valueOf(s.substring(index, i));
    		if(val > 26 || val == 0) break;
    		size += findAllSolutions(i, s, mem);
    	}
    	mem[index] = size;
    	return size;                 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode91DecodeWays test = new LeetCode91DecodeWays();
		System.out.println(test.numDecodings("12"));
		System.out.println(test.numDecodings("226"));
		System.out.println(test.numDecodings("1234"));
		System.out.println(test.numDecodings("1122211"));
	}

}
