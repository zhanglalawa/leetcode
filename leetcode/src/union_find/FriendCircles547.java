package union_find;
/*
 * 典型的union-find
 * 给并查集一个count，每次union成功一次就count--
 */
public class FriendCircles547 {
	class Solution {
		public int findCircleNum(int[][] M) {
			int n = M.length;
			Union Circle = new Union(n);
			for (int i = 0; i < M.length; i++) {
				for (int j = i + 1; j < M[0].length; j++) {
					if (M[i][j] == 1) {
						Circle.unionElements(i, j);
					}
				}
			}

			return Circle.count;
		}
	}

	class Union {
		private int count;
		private int[] parent;
		private int[] rank;

		public Union(int n) {
			parent = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
			count = n;
		}

		private int find(int p) {
			if (p == parent[p]) {
				return p;
			}

			return parent[p] = find(parent[p]);
		}

		public void unionElements(int p, int q) {
			int pRoot = find(p);
			int qRoot = find(q);
			if (qRoot == pRoot) {
				return;
			}

			count--;
			if (rank[pRoot] > rank[qRoot]) {
				parent[qRoot] = pRoot;
			} else if (rank[pRoot] < rank[qRoot]) {
				parent[pRoot] = qRoot;
			} else {
				parent[qRoot] = pRoot;
				rank[pRoot]++;
			}
		}
	}
}
