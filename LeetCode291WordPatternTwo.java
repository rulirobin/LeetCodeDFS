import java.util.HashMap;
import java.util.HashSet;

public class LeetCode291WordPatternTwo {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || str == null) return false;
        return findIfAnyMatch(0,0,pattern,str,new HashMap<>(), new HashSet<>());
    }
    private boolean findIfAnyMatch(int idxP, int idxS, String pattern, String str, HashMap<Character, String> map, HashSet<String> set) {
    	// hashmap is used to store the mapping relationship between pattern and str; hashset is to prevent different pattern from matching to the same string
    	if(idxP == pattern.length() && idxS == str.length()) {
    		return true;
    	}
    	if(idxP == pattern.length() || idxS == str.length()) {
    		return false;
    	}
    	char curr = pattern.charAt(idxP);
    	if(map.containsKey(curr)) {
    		// the mapping exists
    		String mapStr = map.get(curr);
    		int size = mapStr.length();
    		if(idxS + size > str.length()) {
    			return false;
    		}else {
    			return mapStr.equals(str.substring(idxS, idxS + size)) && findIfAnyMatch(idxP + 1, idxS + size, pattern, str, map, set);
    		}
    	}else {
    		// the mapping has not happened yet
    		// prune: calculate the max len could be used to match for curr char
    		int maxLen = calculateMaxLen(idxP, idxS, pattern, str, map);
    		if(maxLen < 1) return false;
    		for(int i = 1; i <= maxLen; i++) {
    			String mapStr = str.substring(idxS, idxS + i);
    			if(set.contains( mapStr)) continue;
    			set.add(mapStr);
    			map.put(curr, mapStr);
    			if(findIfAnyMatch(idxP + 1, idxS + i, pattern, str, map,set)) {
    				return true;
    			}
    			map.remove(curr);
    			set.remove(mapStr);
    		}
    	}
    	return false;
    	
    }
    private int calculateMaxLen(int idxP, int idxS, String pattern, String str, HashMap<Character, String> map) {
    	int lenP = pattern.length();
    	int lenS = str.length();
    	int count = 1;
    	char currChar = pattern.charAt(idxP);
    	int leftLen = lenS - idxS;
    	for(int i = idxP + 1; i < lenP; i++) {
    		char ch = pattern.charAt(i);
    		if(ch == currChar) {
    			count++;
    		}else {
    			leftLen -= map.containsKey(ch) ? map.get(ch).length() : 1;
    		}
    	}
    	return (int) leftLen / count;
    }
	public static void main(String[] args) {
		LeetCode291WordPatternTwo test = new LeetCode291WordPatternTwo();
		System.out.println(test.wordPatternMatch("abab", "redblueredblue"));
		System.out.println(test.wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(test.wordPatternMatch("aabb", "xyzabcxzyabc"));
		System.out.println(test.wordPatternMatch("d", "e"));
		System.out.println(test.wordPatternMatch("ab", "aa"));
		System.out.println(test.wordPatternMatch("aba", "aaaa"));
		System.out.println(test.wordPatternMatch("itwasthebestoftimes","ittwaastthhebesttoofttimes"));
		// TODO Auto-generated method stub

	}

}
