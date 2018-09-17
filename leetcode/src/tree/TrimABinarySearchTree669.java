package tree;

public class TrimABinarySearchTree669 {
	class Solution {
		//递归解法，树空了不再往下找
		//返回修剪后的树根
		//不在区间内的 如果大于R 说明这个修剪后的树根一定在左子树上
		//如果小于L，说明这个修剪后的树根一定在右子树上
		//如果在区间内，则是修左修右
		//然后返回root;
		public TreeNode trimBST(TreeNode root, int L, int R) {
			if (root == null) {
				return null;
			}

			if (root.val > R) {
				return trimBST(root.left, L, R);
			}

			if (root.val < L) {
				return trimBST(root.right, L, R)
			}
			
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
			return root;
		}
	}
}
