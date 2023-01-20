class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        solve(nums, 0, -101, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
    
    void solve(int[] nums, int i, int prev, List<Integer> list, Set<List<Integer>> ans) {
        if (list.size() > 1) ans.add(new ArrayList<>(list));
        
        for (int index = i; index < nums.length; index++) {
            if (nums[index] >= prev) {
                list.add(nums[index]);
                solve(nums, index+1, nums[index], list, ans);
                list.remove(list.size()-1);
            }
        }
    }
}