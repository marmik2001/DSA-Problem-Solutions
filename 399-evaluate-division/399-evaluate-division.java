class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> map = new LinkedHashMap<>();
        for(int i=0;i<equations.size();i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            map.computeIfAbsent(a,x->new ArrayList<>()).add(new Pair(b, values[i]));
            map.computeIfAbsent(b,x->new ArrayList<>()).add(new Pair(a, 1/values[i]));
        }
        int n = map.size();
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            res[i] = bfs(map,queries.get(i));
        }
        return res;
    }
    private double bfs(Map<String, List<Pair<String, Double>>> map,List<String> query){
        String a = query.get(0);
        String b = query.get(1);
        if(!map.containsKey(a))
            return -1;;        
        HashSet<String> visited = new HashSet<>();
        Queue<Pair<String,Double>> queue = new LinkedList();
        queue.add(new Pair(a,1.0));
        visited.add(a);
        while(!queue.isEmpty()){
            Pair<String, Double> num = queue.poll();
            if(num.getKey().equals(b))return num.getValue();
            if(!map.containsKey(num.getKey()))continue;
            for(Pair<String, Double> x:map.get(num.getKey())){
                if(visited.contains(x.getKey()))continue;
                visited.add(x.getKey());
                double val = num.getValue()*x.getValue();
                queue.add(new Pair(x.getKey(), val));
            }
        }
        return -1.0;
    }
}