class Solution {
    
    class TrieNode{
        TrieNode[] next=new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();
        for(String word : words){
            TrieNode curr=root;
            for(char c : word.toCharArray()){
                if(curr.next[c-'a']==null)
                    curr.next[c-'a']=new TrieNode();
                curr=curr.next[c-'a'];
            }
            curr.word=word;
        }
        return root;
    }
    int[] nexti=new int[]{0,-1,0,1};
    int[] nextj=new int[]{-1,0,1,0};
    
    public boolean isValid(int i, int j, char[][] temp){
        return (i>=0 && i<temp.length && j>=0 && j<temp[i].length && temp[i][j]!='#');
    }
    
    public void dfs(int i, int j, TrieNode root, char[][]board, List<String> ans){
        if(!isValid(i,j,board))return;
        
        char c=board[i][j];
        if(root.next[c-'a']==null)return;
        root=root.next[c-'a'];
        
        if(root.word!=null){
            ans.add(root.word);
            root.word=null;
        }
        
        board[i][j]='#';
        
        for(int k=0; k<4; k++){
            dfs(i+nexti[k], j+nextj[k], root, board, ans);
        }
        board[i][j]=c;
        
    }
    

    public List<String> findWords(char[][] board, String[] words) {
        if(words.length==0 || (board.length==0 && board[0].length==0))return new ArrayList<>();
        List<String> ans=new ArrayList<String>();
        
        TrieNode root = buildTrie(words);

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                dfs(i,j,root,board,ans);
            }
        }
        return ans;
    }
}