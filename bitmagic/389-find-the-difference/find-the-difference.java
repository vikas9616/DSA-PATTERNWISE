class Solution {
    public char findTheDifference(String s, String t) {
       char ch =0;
       int len = t.length();

       for(int i=0; i<len; i++){
        if(i<s.length()){
            ch ^= s.charAt(i);
        }
        ch ^= t.charAt(i);
       }
       return ch;

    }
}