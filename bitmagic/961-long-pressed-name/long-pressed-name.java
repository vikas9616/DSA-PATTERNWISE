class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int l=0,m = name.length(), n = typed.length();
        for(int i=0; i<n; i++){
            if(l<m && name.charAt(l)==typed.charAt(i)){
                ++l;
            }
            else if(i==0 || typed.charAt(i) != typed.charAt(i-1))
               return false;
        }
        return l==m;

    }
}