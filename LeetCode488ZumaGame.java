import java.util.HashMap;
import java.util.Map;

public class LeetCode488ZumaGame {
	private int minLen;
    public int findMinStep(String board, String hand) {
        if(board == null || hand == null || board.length() == 0 || hand.length() == 0) return -1;
        minLen = hand.length() + 1;
        Map<Character, Integer> balls = new HashMap<>();
        for(char ch: hand.toCharArray()) {
        	if(!balls.containsKey(ch)) {
        		balls.put(ch, 0);
        	}
        	balls.put(ch,balls.get(ch) + 1);
        }
        findMinInAllSolutions(0, balls, board);
        return  (minLen == hand.length() + 1) ? -1: minLen;
    }
    private void findMinInAllSolutions(int cnt, Map<Character,Integer> balls, String board) {
    	int len = board.length();
    	if(len == 0) {
    		if(minLen > cnt) {
    			minLen = cnt;
    		}
    		return;
    	}
    	if(balls.isEmpty()) {
    		return;
    	}
    	for(int i = 0; i < len; i++) {
    		char ch = board.charAt(i);
    		if(balls.containsKey(ch)){
    			int num = balls.get(ch);
    			// throw one ball
    			if(i < len - 1 && ch == board.charAt(i + 1)) {
    				String newBoard = generateBoard(i-1,i+2, board);
    				if(num - 1 <= 0) {
    					balls.remove(ch);
    				}else{
    					balls.put(ch, num -1 );
    				}
    				findMinInAllSolutions(cnt + 1, balls, newBoard);
    				balls.put(ch, num);
    			}
    			else if(num > 1){
    				// throw two balls
    				String newBoard = generateBoard(i-1, i+ 1, board);
    				if(num - 2 == 0) {
    					balls.remove(ch);
    				}else{
    					balls.put(ch, num -2 );
    				}
    				findMinInAllSolutions(cnt + 2, balls,newBoard);
    				balls.put(ch, num);
    			}
    		}
    	}
    }
    private String generateBoard(int left, int right, String board) {
    	while(left >= 0 && right < board.length()) {
    		int i = left;
    		int j = right;
    		char ch = board.charAt(i);
    		int count = 0;
    		while(i >= 0 && board.charAt(i) == ch) {
    			i--;
    			count++;
    		}
    		while(j < board.length() && board.charAt(j) == ch) {
    			j++;
    			count ++;
    		}
    		if(count >=3) {
    			left = i;
    			right = j;
    		}else {
    			break;
    		}
    	}
    	StringBuilder newBoard = new StringBuilder();
    	if(left >= 0) {
    		newBoard.append(board.substring(0,left + 1));
    	}
    	if(right < board.length()) {
    		newBoard.append(board.substring(right)) ;
    	}
    	return newBoard.toString();
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode488ZumaGame test = new LeetCode488ZumaGame();
		System.out.println(test.findMinStep("WWRRBBWW", "WRBRW"));
	}

}
