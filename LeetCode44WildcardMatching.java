
public class LeetCode44WildcardMatching {
	// the difference that leetcode 10 is that * matches any sequence of characters. so if character equals *, there are two options. 
	// one is to replace the character from s. another is not to replace the character
	 public boolean isMatch(String s, String p) {
		 if(s == null || p == null) return false;
		 return findIfMatch(0,0,s,p, new Boolean[s.length()+1][p.length()+1]);
		 
		 
	 }
	 private boolean findIfMatch(int idxS, int idxP, String s, String p,Boolean[][] mem) {
		 if(idxP == p.length()) {
			 return idxS == s.length();
		 }
		 if(idxS == s.length()) {
			 return p.charAt(idxP) == '*' && findIfMatch(idxS, idxP + 1, s,p,mem);
 		 }
		 if(mem[idxS][idxP] !=null) return mem[idxS][idxP];
		 if(p.charAt(idxP) == '?' || p.charAt(idxP) == s.charAt(idxS)) {
			if(findIfMatch(idxS + 1, idxP + 1, s, p,mem)) {
				mem[idxS][idxP] = true;
				return true;
			}
		 }
		 else if (p.charAt(idxP) == '*'){
			 if(findIfMatch(idxS, idxP + 1, s, p, mem) || findIfMatch(idxS + 1, idxP, s, p, mem)) {
				mem[idxS][idxP] = true;
				return true;
			 }
		 }
		 else {
			 mem[idxS][idxP] = false;
			 return false;
		 }
		mem[idxS][idxP] = false;
		return false;
	 }
	public static void main(String[] args) {
		LeetCode44WildcardMatching test = new LeetCode44WildcardMatching();
		System.out.println(test.isMatch("a", "aa"));
		System.out.println(test.isMatch("aa", "a"));
		System.out.println(test.isMatch("aa", "*"));
		System.out.println(test.isMatch("cb", "?a"));
		System.out.println(test.isMatch("adceb", "*a*b"));
		System.out.println(test.isMatch("acdcb", "a*c?b"));
		System.out.println(test.isMatch("abefcdgiescdfimde","ab*cd?i*de"));
		
		// TODO Auto-generated method stub

	}

}
