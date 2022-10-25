class Solution {
    public boolean arrayStringsAreEqual(String[] arr1, String[] arr2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        for (String word : arr1) {
            s1.append(word);
        }
        
        for (String word : arr2) {
            s2.append(word);
        }
        
        return s1.toString().equals(s2.toString());
    }
}