class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for(int i=1; i<folder.length; i++){
            String lastFolderAdded = res.get(res.size()-1) +"/";
            int idx = folder[i].indexOf(lastFolderAdded);
            if(idx!=0){
                res.add(folder[i]);
            }
        }
        return res;
    }
}