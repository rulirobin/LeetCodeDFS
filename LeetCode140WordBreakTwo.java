import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode140WordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || wordDict == null) return res;
        boolean[] mem = new boolean[s.length()];
        Arrays.fill(mem, true);
        findAllSolutions(0,new StringBuilder(), s, res, wordDict, mem);
        return res;
    }
    private void findAllSolutions(int index, StringBuilder path, String s,List<String> res, List<String> wordDict, boolean[] mem) {
    	if(index == s.length()) {
			path.setLength(path.length() - 1);
			res.add(path.toString());
			return;
    		
    	}
    	if(!mem[index]) return;
    	int size = res.size();
    	for(int i = index + 1; i <= s.length(); i++) {
    		String curr = s.substring(index, i);
    		int len = path.length();
    		if(wordDict.contains(curr)) {
    			path.append(curr + " ");
    			findAllSolutions(i, path, s, res, wordDict,mem);
    			path.setLength(len);
    		}
    	}
    	if(size == res.size()) {
    		mem[index] = false;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode140WordBreakTwo test = new LeetCode140WordBreakTwo();
		List<String> wordDict = new ArrayList();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		List<String> res = test.wordBreak("catsanddog", wordDict);
		for(String str: res) {
			System.out.println(str);
		}
	}

}
