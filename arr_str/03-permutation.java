	/**
	 * 判断一个字符串中的字符串经过调制后是否能变成另一个字符串
	 * 思路： 使用对字符的异或方法， 两个相同的数异或后为零。
	 * 因此如果两个字符串中的字符相同的话那么异或后的结果就是零
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean permutation(String s, String t){
		if(s.length() != t.length()) return false;
		int ck = 0;
		for(int i = 0; i<s.length(); i++){
			int c1 = s.charAt(i);
			int c2 = t.charAt(i);
			ck ^= (c1 ^ c2);	
		}
		if(ck == 0) return true;
		return false;
	}
	/**
	 * 思路： 使用整型数组来存储字符数量。 先对一个字符串中的字符中的字符进行统计加操作。
	 * 对第二个字符串进行统计减操作，如果统计过程中出现负数，就说明两字符串中的字符有不一致的情形。
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean permutation1(String s, String t){
		if(s.length() != t.length()) return false;
		int[] ck = new int[256];
		char[] cs = s.toCharArray();
		for(char c : cs)
			ck[c]++;
		for(int i = 0; i<t.length(); i++){
			char cur = t.charAt(i);
			if(--ck[cur] < 0) return false;
		}
		return true;
	}