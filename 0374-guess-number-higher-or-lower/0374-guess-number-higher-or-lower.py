# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        lo = 1
        hi = n
        
        while lo <= hi :
            mid = (lo+hi) >> 1
            
            if guess(mid) == 0:
                return mid
            elif guess(mid) == 1:
                lo = mid + 1
            else:
                hi = mid - 1
        