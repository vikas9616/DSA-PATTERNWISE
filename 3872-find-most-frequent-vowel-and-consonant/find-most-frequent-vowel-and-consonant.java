class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(ch=='a' || ch=='e'||  ch=='i' ||  ch=='o'||  ch=='u') {
                hm1.put(ch, hm1.getOrDefault(ch,0)+1);
            }else{
                hm2.put(ch, hm2.getOrDefault(ch,0)+1);
            }
        }
        int count1=0;
        for(Map.Entry<Character, Integer> en : hm1.entrySet()){
            if(en.getValue()>count1){
                count1=en.getValue();
            }
        }
        int count2=0;
        for(Map.Entry<Character, Integer> en : hm2.entrySet()){
            if(en.getValue()>count2){
                count2=en.getValue();
            }
        }

        return count1+count2;
    }
}