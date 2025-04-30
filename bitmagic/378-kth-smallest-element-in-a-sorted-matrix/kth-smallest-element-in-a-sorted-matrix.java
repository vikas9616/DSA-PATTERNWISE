class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int [] res= new int[n*n];
        int s=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                res[s++] = matrix[i][j];
            }
        }
        Arrays.sort(res);
        return res[k-1];
    }
}