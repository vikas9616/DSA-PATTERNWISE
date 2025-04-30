class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];

        while(min<=max){
            int mid = min + (max-min)/2;
            int count=0, maxNum=min;
            for(int r=0, c=n-1; r<n; r++){
                while(c>=0 && matrix[r][c]>mid) c--;
                if(c>=0){
                    count += c+1;
                    maxNum = Math.max(maxNum, matrix[r][c]);
                }else{
                    break;
                }
            }
            if(count==k) return maxNum;
            else if(count<k) min= mid+1;
            else max = mid-1;
        }
        return min;
    }
}