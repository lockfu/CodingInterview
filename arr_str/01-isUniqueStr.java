     /**
	 * 确定一个字符串中的所有字符是否全都不同 
	 * @param str
	 * @return
	 */
	public static boolean uniqueStr(String str){
		if(str.length() > 256) return false; // 超过ASCII的256个字符则确定有重复的
		int checker = 0;
		for(int i = 0; i<str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1<<val)) > 0 ){  // 位置冲突  则有重复字符
				return false;
			}
			checker |=  (1<<val); 
		}
		return true;
	}
	public static boolean uniqueStr2(String str){
		if(str.length() > 256) return false;
		if(null == str) return true;
		boolean[] cs = new boolean[256];  // 使用字符的索引对应boolean数组来求解
		for(int i = 0; i<str.length(); i++){
			int c = str.charAt(i);
			if(cs[c]) return false;  // 如果改索引以及置为true 则先前有符号 --- 重复
			cs[c] = true;
		}
		return true;
	}