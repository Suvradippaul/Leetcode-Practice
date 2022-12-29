class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Queue<Task> taskQueue = new PriorityQueue<>((task1, task2) -> task1.startTime - task2.startTime); 
        
        Queue<Task> availableQueue = new PriorityQueue<>(new SortByProcessingTime());
        
        for (int i = 0; i < n; i++) {
            taskQueue.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        
        int[] ans = new int[n];
        int currTime = taskQueue.peek().startTime;
        
        for (int i = 0; i < n;) {
            while (!taskQueue.isEmpty() && taskQueue.peek().startTime <= currTime) {
                availableQueue.add(taskQueue.poll());
            }
            if (!availableQueue.isEmpty()) {
                Task t = availableQueue.poll();
                currTime += t.processingTime;
                ans[i] = t.index;
                i++;
            }
            else {
                currTime = taskQueue.peek().startTime;
            }
        }
        
        return ans;
    }
}

class Task {
    int index; 
    int startTime;
    int processingTime;
    
    Task(int index, int startTime, int processingTime) {
        this.index = index;
        this.startTime = startTime;
        this.processingTime = processingTime;
    }
}


class SortByProcessingTime implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        if (t1.processingTime == t2.processingTime) return t1.index - t2.index;
        
        return t1.processingTime - t2.processingTime;
    }
}