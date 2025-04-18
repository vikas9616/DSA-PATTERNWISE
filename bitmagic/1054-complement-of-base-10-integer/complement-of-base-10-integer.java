class Solution {
    public int bitwiseComplement(int n) {
        int num= (int)(Math.floor(Math.log(n)/Math.log(2))) +1;
        return ((1 << num)-1) ^ n;
    }
}