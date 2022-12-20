class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int currRoom = queue.poll();
            for (int canBeUnlocked : rooms.get(currRoom)) {
                if (!visited[canBeUnlocked]) {
                    visited[canBeUnlocked] = true;
                    queue.add(canBeUnlocked);
                }
            }
        }
        
        for (boolean room : visited) {
            if (!room) return false;
        }
        
        return true;
    }
}