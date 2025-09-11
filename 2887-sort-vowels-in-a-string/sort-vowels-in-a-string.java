class Solution {
    public String sortVowels(String s) {
        char[] str = s.toCharArray();
        List<Character> vowelList = new ArrayList<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        for(char c: str){
            if(vowels.contains(c)){
                vowelList.add(c);
            }
        }

        Collections.sort(vowelList);

        int idx = 0;
        for(int i=0;i<str.length;i++){
            if(vowels.contains(str[i])){
                str[i] = vowelList.get(idx);
                idx++;
            }
        }
        return new String(str);
    }
}