class Solution {
    public int[] decode(int[] encoded) {
        int x = 0;
        int n = encoded.length+1;
        for(int i=1; i<=n; i++){
            x ^= i;
        }

        for(int i=1; i<n-1; i += 2){
            x ^= encoded[i];
        }

        int[] perm = new int[n];
        perm[0] = x;
        for(int i=0; i<n-1; i++){
            perm[i+1] = perm[i] ^ encoded[i];
        }
        return perm;



    }
}