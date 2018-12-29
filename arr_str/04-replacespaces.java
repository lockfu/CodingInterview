/**
	 * 假设字符数组中尾部有多余的空间
	 * 初始分配总的字符数量，从尾部开始索引。
	 * @param str
	 * @param length
	 */
	public static void replaceSpaces(char[] str, int length){
		int spacecount = 0, newlength;
		for(int i = 0; i<length; i++){
			if(str[i] == ' ')
				spacecount++;
		}
		newlength = length + spacecount * 2;
		str[newlength] = '\0';
		for(int i = length - 1; i>= 0; i--){
			if(str[i] == ' '){ // 是空格填充%20
				str[newlength - 1] = '0';
				str[newlength - 2] = '2';
				str[newlength - 3] = '%';
				newlength = newlength - 3;
			}else{  // 是正常字符  复制
				str[newlength - 1] = str[i];
				newlength = newlength - 1;
			}
		}
	}
	
	/**
	 * 使用StringBuilder进行拼接字符。
	 * @param str
	 */
	public static void replaceSpaces2(String str){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c == ' '){
				sb.append("%20");
			}else{
				sb.append(c+"");
			}
		}
	}