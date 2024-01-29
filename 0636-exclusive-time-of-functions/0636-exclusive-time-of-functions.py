class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        ans = [0] * n
        stack = []
        
        for log in logs:
            i, status, ts = log.split(':')
            i, ts = int(i), int(ts)
            
            if status == 'start':
                if stack:
                    ans[stack[-1][0]] += ts - stack[-1][1]
                stack.append([i, ts])
            
            else:
                prev_ts = stack.pop()
                ans[i] += ts - prev_ts[1] + 1
                if stack:
                    stack[-1][1] = ts + 1
                    
        return ans
            
            
                
                    
            