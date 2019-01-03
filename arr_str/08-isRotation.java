	/**
	 * 假设有一个方法isSubstring, 可以检查一个单词是否为其它字符串的字串。 给定字符串s1 s2, 判断s2是否由s1旋转成。
	 * 如： waterbottle 是 erbottlewat旋转后的结果.
	 * 
	 * s1 = xy = waterbottle
	 * s2 = yx = erbottlewat
	 * s1s1 = waterbottlewaterbottle 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2){
		if(s1.length() == s2.length() && s1.length() > 0){
			String s1s1 = s1+s1;
			return isSubstring(s1s1,s2);
		}
		return false;
	}