import java.util.HashMap;

public class LeetCode294FlipGame {
    public boolean canWin(String s) {
        if(s == null || s.length() <= 1) return false;
        return findAllSolutions(s.toCharArray(), new HashMap<>());
    }
    private boolean findAllSolutions(char[] board, HashMap<String, Boolean> map) {
    	// pruning: hasmap stores all the board's status
    	String str = new String(board);
    	if(map.containsKey(str)) return map.get(str);
    	for(int i = 0; i < board.length - 1; i++) {
    		if(board[i] == '+' && board[i+1] == '+') {
    			board[i]= '-';
    			board[i+1]= '-';
    			// if the return res is false, it means the other player cannot find the two consecutive + to flip
    			boolean res = findAllSolutions(board, map);
    			board[i]= '+';
    			board[i+1]= '+';
    			
    			if(!res) {
    				return true;
    			}
    		}
    	}
    	map.put(str, false);
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode294FlipGame test = new LeetCode294FlipGame();
		System.out.println(test.canWin("++++"));
	}

}
