class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        int l=1, r=x;
        int mid=-1;
        while(r>=l){
             mid = l + (r-l)/2;
            if( mid == x/ mid){
                return mid;
            }
            else if(mid > x/mid){
                r=mid-1;;
            }else{
                l=mid+1;
            }
        }
        return Math.round(r);
    }
}