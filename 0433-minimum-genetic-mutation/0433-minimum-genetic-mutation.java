class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        
        if (!set.contains(end)) {
            return -1;
        }
        
        char[] chars = {'A', 'C', 'G', 'T'};
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                char[] ch = queue.poll().toCharArray();    // take a string out of queue
                
                for (int j = 0; j < 8; j++) {              // for each position 0 to 7, try 4 different characters [A, C, G, T]
                    char originalCh = ch[j];               // keep a backup of original character at a position
                    
                    for (char c : chars) {
                        ch[j] = c;
                        String str = String.valueOf(ch);    // form a string with new char in that position
                        
                        if (set.contains(str) && str.equals(end)) {   // if the string is 'end' and it is also available in bank, then this level is the ans. Return it
                            return level;
                        }
                        else if (set.contains(str)) {       // if the string is not the end, but is present in bank, then remove it from bank and add it to the queue for further processing.
                            set.remove(str);
                            queue.add(str);
                        }
                    }
                    
                    ch[j] = originalCh;                     // replace ch in that position with original character
                }
            }
            level++;                                 // increase level, because we have checked all possible mutations of genes for a particular string.
        }
        
        return -1;
    }
}