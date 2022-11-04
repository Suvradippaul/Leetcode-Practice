class Solution {
    public String reverseVowels(String s) {
		Set<Character> set = new HashSet<>();
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
        char[] chars = s.toCharArray();
        
        int i = 0;
        int j = chars.length-1;
        while (i < j) {
            while (i < j && !set.contains(chars[i])) {
            	i++;
            }
            while (i < j && !set.contains(chars[j])) {
            	j--;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        
        return String.valueOf(chars);
    }
    
    void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}