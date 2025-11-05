class Solution {
    public int longestConsecutive(int[] nums) {
        // typical complexity for sorting algorithms nlogn, so sorting is not an option
        // what else can be done, if we do not sort the input array?

        // how can we find a start of the sequence? -> it is a number that does not have left neighbor
        // for finding, if we have a left neighbor, we do need to look up the existence of the potential left
        // neighbor.
        // Data structure that allows us O(1) look up time are: Set, HashMap

        // Let's copy the initial array to set
        Set<Integer> numsSet = new HashSet<>();
        for (int num: nums) {
            numsSet.add(num);
        }

        // We should iterate over input array and check, if there is a left neighbour present
        // - if the neighbor present, we start counting the length of a sequence
        int maxSequence = 0;
        for (int num: nums) {
            int sequence = 1;
            int currentNumber = num;
            while (numsSet.contains(currentNumber - 1)) {
                currentNumber--;
                sequence++;
            }

            maxSequence = Math.max(maxSequence, sequence);
        }

        return maxSequence;
        
    }
}