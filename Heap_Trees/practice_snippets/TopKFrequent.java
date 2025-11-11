import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static int[] topKFrequentNumbers(int[] nums, int k) {
        if (nums.length == 0)
            return new int[]{};

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> freq.get(a) - freq.get(b) // might result in overflow if a and b are large numbers (do not fit in int)
        );

        for (int n: freq.keySet()) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static String[] topKFrequentWords(String[] words, int k) {

        if (words.length == 0)
            return new String[]{};

        Map<String, Integer> freq = new HashMap<>();

        for (String w: words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b) -> freq.get(a).equals(freq.get(b))
                        ? b.compareTo(a)
                        : Integer.compare(freq.get(a), freq.get(b))
        );

        for (String key: freq.keySet()) {
            pq.add(key);
            if(pq.size() > k) pq.poll();
        }

        String[] result = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static String[] topKActiveUsers(String[][] logs, int k) {
        if (logs.length == 0) {
            return new String[]{};
        }

        Map<String, Integer> freq = new HashMap<>();
        for (String[] log : logs) {
            freq.put(log[0], freq.getOrDefault(log[0], 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b) ->
                        freq.get(a).equals(freq.get(b))
                                ? b.compareTo(a)
                                : Integer.compare(freq.get(a), freq.get(b))
        );

        for (String key: freq.keySet()){
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }

        String[] result = new String[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static int[] topKSmallestElements(int[] nums, int k) {
        if (nums.length == 0)
            return new int[]{};

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(b,a)
        );

        for (int n: nums){
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int [k];
        for (int i = k-1; i >=0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
}
