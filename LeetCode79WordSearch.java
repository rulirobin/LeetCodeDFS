package dfs;

public class LeetCode79WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j<col; j++) {
        		if(isExist(i,j,0,word,board,visited)) return true;
        	}
        }
        return false;
    }
    private boolean isExist(int i , int j, int index, String word, char[][] board, boolean[][] visited) {
    	if(index == word.length()) {
    		return true;
    	}
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || index > word.length() || board[i][j] != word.charAt(index) || visited[i][j]){
    		return false;
    	}
    	visited[i][j] = true;
    	return isExist(i+1, j, index + 1, word, board, visited) || isExist(i, j+1, index + 1, word, board, visited) || isExist(i-1, j, index + 1, word, board, visited) || isExist(i, j-1, index + 1, word, board, visited);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode79WordSearch test = new LeetCode79WordSearch();
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(test.exist(board, word));
	}

}
