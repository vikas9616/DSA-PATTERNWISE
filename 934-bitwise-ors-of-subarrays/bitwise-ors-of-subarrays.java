class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        for(int num : arr){
            Set<Integer> hs = new HashSet<>();
            hs.add(num);
            for(int x : curr){
                hs.add(x | num);
            }
            curr = hs;
            res.addAll(curr);
        }
        return res.size();
    }
}