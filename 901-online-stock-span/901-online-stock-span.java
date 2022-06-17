class StockSpanner {
    ArrayList<int[]> save;
    public StockSpanner() {
        save = new ArrayList<>();
    }
    
    public int next(int price) {
        if(save.size()==0){
            save.add(new int[]{price,1});
            return 1;
        }
        int ans = 0, i = save.size()-1;
        int[] a = save.get(i);
        while(a[0]<=price){
            ans+=a[1];
            if(i-a[1]>=0) i-=a[1];
            else break;
            a = save.get(i);
        }
        save.add(new int[]{price,ans+1});
        return ans+1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */