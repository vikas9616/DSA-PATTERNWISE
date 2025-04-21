class Solution {
    public int[] shortestToChar(String s, char c) {
        int [] res = new int[s.length()];
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                ls.add(i);
            }
        }

        for(int i=0; i<s.length(); i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<ls.size(); j++){
                min = Math.min(min, Math.abs(i-ls.get(j)));
            }
            res[i] = min;
        }
        return res;
    }
}