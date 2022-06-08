class Solution {
    private class Node {
        Node[] next = new Node[2];
    }

    private Node root;

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        root = new Node();
        HashMap<int[], Integer> index = new HashMap<>();
        for (int i = 0; i < queries.length; i++)
            index.put(queries[i], i);
        Arrays.sort(queries, Comparator.comparingInt(o -> o[1]));
        int i = 0;
        int[] sol = new int[queries.length];
        for (int[] query : queries) {
            while (i < nums.length && nums[i] <= query[1]) {
                add(nums[i]);
                i++;
            }
            if (i == 0) {
                sol[index.get(query)] = -1;
                continue;
            }
            Node x = root;
            int queryAns = 0;
            for (int j = 31; j >= 0; j--) {
                int bit = (query[0] >> j) & 1;
                if (x == null) {
                    if (bit == 1)
                        queryAns += (1 << j);
                } else if (x.next[bit ^ 1] != null) {
                    queryAns += (1 << j);
                    x = x.next[bit ^ 1];
                } else
                    x = x.next[bit];
            }
            sol[index.get(query)] = queryAns;
        }
        return sol;
    }

    private void add(int num) {
        Node x = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (x.next[bit] == null)
                x.next[bit] = new Node();
            x = x.next[bit];
        }
    }
}