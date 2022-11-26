class Job {
    int start;
    int end;
    int profit;
    Job(int s, int e, int p) {
        this.start = s;
        this.end = e;
        this.profit = p;
    }
}

class Solution {
    public int jobScheduling(int[] s, int[] e, int[] p) {
        int n = s.length;
		
		List<Job> jobs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			jobs.add(new Job(s[i], e[i], p[i]));
		}
		
		Collections.sort(jobs, (a, b) -> a.start - b.start);

		int[] dp = new int[n];
		Arrays.fill(dp, -1);

		return solve(jobs, 0, dp);
    }
    
    int solve(List<Job> jobs, int i, int[] dp) {
		if (i == jobs.size()) return 0;

		if (dp[i] != -1) return dp[i];

		int nextI = search(jobs, jobs.get(i).end, i); 
		
		int pick = jobs.get(i).profit + solve(jobs, nextI, dp);
		int notPick = solve(jobs, i+1, dp);
		
		return dp[i] = Math.max(pick, notPick);
	}
    
    int search(List<Job> jobs, int target, int i) {
        int ans = jobs.size();
        int lo = i+1;
        int hi = jobs.size()-1;
        
        while (lo <= hi) {
            int mid = (lo+hi) >> 1;
            if (jobs.get(mid).start >= target) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        
        return ans;
    }
}