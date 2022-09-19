class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        String[] files;
        String root, content;
        List<String> inner;
        for(String path : paths){
            files = path.split(" ");
            root = files[0];
            for(int i = 1; i < files.length; i++){
                content = files[i].split("\\(")[1];
                content = content.substring(0, content.length() - 1);
                inner = map.getOrDefault(content, new ArrayList<>());
                inner.add(root + "/" + files[i].split("\\(")[0]);
                map.put(content, inner);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key).size() > 1)
                ans.add(map.get(key));
        }
        return ans;
    }
}