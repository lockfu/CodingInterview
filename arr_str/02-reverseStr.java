	public static String reverseStr(String str){
		if(null == str || str.length() == 0) return str;
		StringBuilder sb = new StringBuilder();
		for(int i = str.length()-1; i>=0; i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	 public static String reverseString2(String s) {
		 if(s == null || s.length() == 1) 
			 return s;
		 char[] cs = s.toCharArray();  // 转成字符数组
		 int start = 0, end = cs.length -1;
		 char tmp;
		 while(start < end){   // 依次交换首末字符
			 tmp = cs[start];
			 cs[start] = cs[end];
			 cs[end] = tmp;
			 start++;
			 end--;
		 }
		 return new String(cs);
	 }
	 
	 // c语言解法
//		void reverse(char *str){
//			char *end = str;
//			char tmp;
//			if(str){
//				while(*end){
//					++end;
//				}
//				--end;
//			}
//			while(str < end){
//				tmp = *str;
//				*str++ = *end;
//				*end-- = tmp;
//			}
//		}