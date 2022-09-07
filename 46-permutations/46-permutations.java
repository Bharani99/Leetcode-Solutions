class Solution {
    
        
    List<List<Integer>> ans=new ArrayList();    
    public void dfs(ArrayList<Integer> list, ArrayList<Integer> res){
        
        if(list.isEmpty()){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i=0; i<list.size(); i++){
            ArrayList<Integer> temp=new ArrayList(list);
            res.add(temp.get(i));
            temp.remove(i);
            dfs(temp, res);
            res.remove(res.size()-1);
            
        }
        
    }
    
    public List<List<Integer>> permute(int[] n) { 
        ArrayList<Integer> temp = new ArrayList();
        
        for(int i=0; i<n.length; i++)temp.add(n[i]);
        
        dfs(temp, new ArrayList());
        return ans;
    }
}