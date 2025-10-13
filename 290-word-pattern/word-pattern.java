class Solution {
    public boolean wordPattern(String pattern, String s) {
       String arr[]=s.split(" ");
       if(pattern.length()!=arr.length) return false;
       Map<Character,String> map = new HashMap<>();
       Set<String> set = new HashSet<>();
       for(int i=0;i<pattern.length();i++){
        char c = pattern.charAt(i);
        String w = arr[i];
        if(map.containsKey(c)){
            if(!map.get(c).equals(w))
            return false;
        }
        else{
            if(set.contains(w))
            return false;
            map.put(c,w);
            set.add(w);
        }
       }
       return true;
    }
}