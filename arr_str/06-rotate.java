public static void rotate(int[][] A, int n) {
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// 保存 上值
				int top = A[first][i];
				// 左 - 上
				A[first][i] = A[last - offset][first];
				// 下 - 左
				A[last - offset][first] = A[last][last - offset];
				// 右 - 下
				A[last][last - offset] = A[i][last];
				// 上 - 右
				A[i][last] = top;
			}
		}
	}

	public static void rotate1(int[][] matrix) {
		if (matrix == null || matrix.length == 1)
			return;
		rotateImg(matrix, 0);
	}
	private static void rotateImg(int[][] A, int c) {
		int count = A.length - c * 2;
		if (count == 1 || count == 0)
			return;
		if (count == 2) {
			int temp = A[c][c];
			A[c][c] = A[c + 1][c];
			A[c + 1][c] = A[c + 1][c + 1];
			A[c + 1][c + 1] = A[c][c + 1];
			A[c][c + 1] = temp;
			return;
		}
		int len = A.length;
		int i = c;
		int end = len - c - 1;
		for (int k = 0; k < count - 1; k++) {
			int temp = A[i][i + k];
			A[i][i + k] = A[end - k][i];
			A[end - k][i] = A[end][end - k];
			A[end][end - k] = A[i + k][end];
			A[i + k][end] = temp;
		}
		rotateImg(A, c + 1);
	}