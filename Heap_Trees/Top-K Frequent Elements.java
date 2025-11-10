class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k)
            return nums;

        // The top-k frequent element usually means that we need to use heap (in Java it is a priority Queue)
        // to store information about our elements
        // what exactly will be stored? we need to store the numbers itself, but we put them in the queue based on their frequency
        // now - that means, we need to know frequency of the elements beforehand. Or! We should be able to modify it "on the fly". But the eap does not support that, so it means I will have to compute frequencies first.
        // My idea will be to create a record Nums, which will have attributes: number and frequency
        // to calculate frequency we have to get the key (number) from the map and modify the value - frequency

        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>( 
                                               // construct min-heap        
            (a,b) -> freq.get(a) - freq.get(b) // if frequency of a > frequency of b -> put a to the top of the heap, otherwise put b
        );

        for (int n: freq.keySet()) {
            pq.add(n);
            if (pq.size() > k) // limit size of the heap to k elements
                pq.poll();
        }

        int[] top = new int[k]; // convert heap to array
        for (int i = k - 1; i >= 0; i--) {
            top[i] = pq.poll();
        }

        // complexity: O(n*log k), where k - is top "K" elements, n - size of nums array
        
        return top;
    }
}