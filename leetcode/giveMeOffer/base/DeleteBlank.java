package base;

public class DeleteBlank {
	// �����صĽⷨ ת����charArray
	// Ȼ���ͷ��β������ȥ��һ���µ��ַ���
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

	// ��ô�п���ԭ���ƶ���
	// �����ո��˰Ѻ�����ַ�������
	// ����������ͷ��β������������O��n^2)
	// ���ǿ��Ǵ�β��ȥ���죬������ָ��
	// �Ȱ��ַ�������������2*�ո���Ϊ%20�ȿո���������ַ�
	// �Ӻ���ǰ���Լ��ٺܶ��ƶ�����
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
