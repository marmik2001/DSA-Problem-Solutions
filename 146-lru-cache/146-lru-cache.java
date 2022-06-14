class LRUCache {
    class Node{
        int key,val;
        Node prev, next;
        Node(){}
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    HashMap<Integer,Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node x = map.get(key);
            delete(x);
            put(x.key,x.val);
            return x.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node x;
        if(map.containsKey(key)){
            x = map.get(key);
            delete(x);
            x.val = value;
        }else{
            x = new Node(key,value);
            if(capacity==0) delete(tail.prev);
        }
        capacity--;
        insert(x);
        map.put(key,x);
    }

    private void insert(Node x){
        x.prev = head;
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
    }

    private void delete(Node x){
        if(x.prev!=null)
            x.prev.next = x.next;
        if(x.next!=null)
            x.next.prev = x.prev;
        map.remove(x.key);
        capacity++;
    }
}