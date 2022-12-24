class Solution {
    class Pair {
		int points;
		int id;
		public Pair(int points, int id) {
			this.points = points;
			this.id = id;
		}
	}
	
	class Cust_Comparator implements Comparator<Pair>{
		@Override
		public int compare(Pair p1, Pair p2) {
			if (p1.points == p2.points) return p1.id - p2.id;
			return p2.points - p1.points;
		}
		
	}
	
	public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] reports, int[] student_id, int k) {
        return solve(positive_feedback, negative_feedback, reports, student_id, k);
    }
    
    List<Integer> solve(String[] positive_feedback, String[] negative_feedback, String[] reports, int[] student_id, int k) {
        HashSet<String> positive = new HashSet<>();
        HashSet<String> negative = new HashSet<>();
        
        for (String s : positive_feedback) {
        	positive.add(s);
        }
        
        for (String s : negative_feedback) {
        	negative.add(s);
        }
        
        List<Pair> students = new ArrayList<>();
        
        int i = 0;
        for (String report : reports) {
        	int student = student_id[i];
        	int points = 0;
        	String[] words = report.split(" ");
        	for (String word : words) {
        		if (positive.contains(word)) points += 3;
        		else if (negative.contains(word)) points -= 1;
        	}
        	i++;
        	students.add(new Pair(points, student));
        }
        
        Collections.sort(students, new Cust_Comparator());
        
        List<Integer> ans = new ArrayList<>();
        for (int in = 0; in < k; in++) {
        	ans.add(students.get(in).id);
        }
        
        return ans;
    }
}