public static void setZeros(int[][] A){
		boolean[] row = new boolean[A.length];
		boolean[] col = new boolean[A[0].length];
		
		for(int i = 0; i<A.length; i++){
			for(int j = 0; j<A[0].length; j++){
				if(A[i][j] == 0){   // 标记为0的行列数
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i = 0; i<A.length; i++){   // 将保护0元素行列数的元素置0
			for(int j = 0; j<A[0].length; j++){
				if(row[i] || col[j]){
					A[i][j] = 0;
				}
			}
		}
	}
	
	public static void setZeroes1(int[][] matrix) {
		if(matrix == null)
			return ;
		int MODIFIED = -1000;
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				if(matrix[i][j] == 0){
					for(int k = 0; k<matrix[i].length; k++){
						if(matrix[i][k] != 0)
							matrix[i][k] = MODIFIED;
					}
					for(int k = 0; k<matrix.length; k++){
						if(matrix[k][j] != 0)
							matrix[k][j] = MODIFIED;
					}
				}
			}
		}
		for(int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[i].length; j++){
				if(matrix[i][j] == MODIFIED){
					matrix[i][j] = 0;
				}
			}
		}
	}