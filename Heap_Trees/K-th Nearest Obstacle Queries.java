class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int[] result = new int[queries.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (Math.abs(b[0]) + Math.abs(b[1])) - (Math.abs(a[0]) + Math.abs(a[1])) //max-heap
        );

        
        for(int i = 0; i < queries.length; i++) {
            pq.add(queries[i]);
            if (pq.size() > k) 
                pq.poll();

            if (i + 1 < k) {
                result[i] = -1;
            } else {
                int[] point = pq.peek();
                result[i] = distance(point[0],point[1]);
            }
        }

        return result;
        
    }

    public int distance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}