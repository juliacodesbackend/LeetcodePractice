class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // what unites grouped anagrams? anagrams have exactly same letters
        // lowercase english letters a,b,c,d,e,f,g,...z
        // 1 group: a,e,t {eat, tea, ate}
        // 2 group: a,n,t {tan, nat}
        // 3 group: a,b,t {bat}

        // I need to store letters of the first word conveniently, so that I can compare them to the letters of a next word, to decide, whether they are anagrams or not. 
        // The simple array might not be enough, therefore I need a mapping. 
        // What if for each new group I create an array of english letters with counts of how often the letter appears 
        // f.e. for eat
        // [1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]
        // for tea the array will be the same:
        // [1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]
        // and for ate also:
        // [1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]
        // where index 0 corresponds to # of occurences of letter a, index 1 - of # of occurence of letter b, etc.
        // I will store data I processed in a map
        // 1) I need to construct such array for a group - it will be the key. 
        // 2) For a new word, I first create a frequency array, then look for it in the map
        // 3) If such key already exists - add the word to values, if not - add new key to the map
        // so the map will look like:
        // [1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0]: {eat, tea, ate}
        // constucting an array for a new group might happen O(n) times in a worst-case scenario, if every word is unique
        // constructung frequency array for a new word is O(m), where m - is average length of the word
        // so complexity is O(n*m)
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s: strs) {
            int[] freq = new int[26];
            for (char c: s.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);
            anagramGroups.putIfAbsent(key, new ArrayList<>());
            anagramGroups.get(key).add(s);
        }

        // what to note:
        // Map<int[], List<String>> - will not work, because in java, hash maps use .equals() or .hashCode()method for hashing
        // if you compare two int[] and int[] they will not be the same, because they are two separate objects in memory, therefor should convert int[] to a String for comparison (Arrays.toString())

        // we substract c - 'a' to get to the indexes 0 - 25. Because in Unicode/ASCII, a = 97, b = 98, c = 99, etc.
        // to not jump out of array index we make sure that we move to the 0 - 25 range.

        return new ArrayList<>(anagramGroups.values());
        
    }
}