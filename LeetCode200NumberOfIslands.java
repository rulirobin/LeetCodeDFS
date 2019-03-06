import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200NumberOfIslands {
    public int numIslands(char[][] grid) {
    	if(grid == null || grid.length == 0 || grid[0]== null || grid[0].length == 0) return 0;
    	int row = grid.length;
    	int col = grid[0].length;
    	boolean[][] visited = new boolean[row][col];
    	int count = 0;
    	Queue<int[]> queue = new LinkedList<>();
    	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			if(!visited[i][j] && grid[i][j] == '1') {
    				int[] loc = {i,j};
    				visited[i][j] = true;
    				queue.offer(loc);
    				while(!queue.isEmpty()) {
    					int[] curr = queue.poll();
    					for(int[] dir: dirs) {
    						int rowI = dir[0] + curr[0];
    						int colJ = dir[1] + curr[1];
    						if(rowI >= 0 && rowI < row && colJ >= 0 && colJ < col && grid[rowI][colJ] == '1' && !visited[rowI][colJ]) {
    							visited[rowI][colJ] = true;
    							queue.offer(new int[] {rowI, colJ});
    						}
    					}
    				}
    				count++;
    			}
    		}
    	}
    	return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode200NumberOfIslands test = new LeetCode200NumberOfIslands();
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(test.numIslands(grid));
	}

}
