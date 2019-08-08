"""
greedy algorithm, from left to right, must flip if the first is zero
pay attention to invariant
sum mode K could be meaningful
"""

class Solution:
    count  = 0
    def minKBitFlips(self, A: List[int], K: int) -> int:
        if(len(A) < K):
            return -1
        
        ptr = 0
        
        count = 0
        
        temp = 0
        
        noZero = True
        
        while True:
            if(len(A) - ptr <= K):
                if(sum(A[ptr:]) == (len(A)-ptr)):
                    return count
                elif(sum(A[ptr:]) == 0 and (len(A) - ptr) == K):
                    return count + 1
                else:
                    return -1
            
            if(A[ptr] == 1):
                ptr += 1
            else:
                count += 1
                for i in range(K):
                    A[ptr+i] = abs(A[ptr+i]-1)
                    if(A[ptr+i] == 1 and noZero):
                        temp+=1
                    else:
                        noZero = False
                ptr += temp
                temp = 0