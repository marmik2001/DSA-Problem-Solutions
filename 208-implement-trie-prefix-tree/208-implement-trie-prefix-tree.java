class Trie {
    
    class Node{
        boolean wordEndsAt;
        Node[] arr;
        Node(){
            wordEndsAt = false;
            arr = new Node[26];
        }
    }
    
    Node rootNode;
    
    public Trie() {
      rootNode = new Node();  
    }
    
    public void insert(String word) {
        Node x = rootNode;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(x.arr[index]==null)
                x.arr[index] = new Node();
            x = x.arr[index];
        }
        x.wordEndsAt = true;
    }
    
    public boolean search(String word) {
        Node x = rootNode;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(x.arr[index]==null)
                return false;
            x = x.arr[index];
        }
        return x.wordEndsAt;
    }
    
    public boolean startsWith(String prefix) {
        Node x = rootNode;
        for(char c:prefix.toCharArray()){
            int index = c-'a';
            if(x.arr[index]==null)
                return false;
            x = x.arr[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */