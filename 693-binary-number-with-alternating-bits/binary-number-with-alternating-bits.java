class Solution {
    public boolean hasAlternatingBits(int n) {
        int curr = n%2;
        n = n/2;
        while(n>0){
            if(curr == n%2 ) return false;
            curr = n%2;
            n = n/2;
        }
        return true;
    }
}