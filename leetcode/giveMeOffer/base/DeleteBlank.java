package base;

public class DeleteBlank {
	// 最朴素的解法 转换成charArray
	// 然后从头到尾遍历，去做一个新的字符串
	public class Solution1 {
		public String replaceSpace(StringBuffer str) {
			String s = str.toString();
			char[] charArray = s.toCharArray();
			StringBuffer ret = new StringBuffer();
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == ' ') {
					ret.append("%20");
				} else {
					ret.append(charArray[i]);
				}
			}
			return ret.toString();
		}
	}

	// 有么有可能原地移动？
	// 遇到空格了把后面的字符串后移
	// 但是这样从头到尾的做法最终是O（n^2)
	// 我们考虑从尾部去改造，用两个指针
	// 先把字符串的容量扩大2*空格，因为%20比空格多了两个字符
	// 从后往前可以减少很多移动次数
	public class Solution2 {
		public String replaceSpace(StringBuffer str) {
			int extraSpace = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					extraSpace += 2;
				}
			}

			int oldLength = str.length();
			int newLength = oldLength + extraSpace;
			str.setLength(newLength);

			for (oldLength--, newLength--; oldLength >= 0; oldLength--) {
				if (str.charAt(oldLength) == ' ') {
					str.setCharAt(newLength--, '0');
					str.setCharAt(newLength--, '2');
					str.setCharAt(newLength--, '%');
				} else {
					str.setCharAt(newLength--, str.charAt(oldLength));
				}
			}
			
			return str.toString();
		}
	}
}
