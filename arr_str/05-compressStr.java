/**
	 * 压缩字符串
	 * 如 aabbbcccd ==> a2b3c3d1
	 * @param str
	 * @return  返回更短的字符 如果原字符更短 则返回原字符 否则返回压缩后的字符
	 */
	public static String compressStr(String str){
		if(null == str || str.length()== 0 || str.length() == 1)
			return str;
		StringBuilder sb = new StringBuilder();
		char cur = str.charAt(0);
		int count = 1;
		sb.append(cur+"");
		// 迭代访问 
		for(int i = 1; i<str.length(); i++){
			char tmp = str.charAt(i);
			if(cur == tmp){   // 相同的字符则增加数量
				count++;
				if(i == str.length()-1){
					sb.append(count + "");
				}
			}else{   // 不同是字符 更新StringBuilder
				sb.append(count + "");
				cur = tmp;
				sb.append(cur + "");
				count = 1;
			}
		}
		if(sb.length() >= str.length()) return str;
		else return sb.toString();
	}