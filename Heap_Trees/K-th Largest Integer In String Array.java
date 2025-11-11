class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // comparing and using Integer or int here does not work, since numbers can be extremely big -> results in overflow
        // therefore it is better to figure out how to compare two Strings without converting them to int/Integer
        // length of the string is good indicator, since we are guaranteed not to have leading zeros
        // longer string is bigger - that is one;
        // what to do if strings have same length? 
        // compare strings lexicografically = by their UNICODE values
        // f.e. '1234' and '4321' -> '1' is smaller than '4'; '2' < '3'; etc. comparison will stop already at the first digit
        // use min heap, to have smaller values at the top of the queue, so that you can poll them once the k-th element is reached (you do not need small values beyond k)

        if (nums.length == 0)
            return "";

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a,b) -> a.length() == b.length()
                    ? a.compareTo(b)        // lexicografically smaller string will be prefered
                    : Integer.compare(a.length(), b.length())
        );

        for(String n: nums){
            pq.add(n);
            if (pq.size() > k) pq.poll(); // remove smallest elements
        }

        return pq.poll();
    }
}