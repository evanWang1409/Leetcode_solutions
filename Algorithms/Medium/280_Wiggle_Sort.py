"""
Akuna Capital
Greedy algorithm
Best solutoin, might need optimization, but this one pass swapping is O(n), the best complexity
"""

class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        if(len(nums) == 2):
            if(nums[0] > nums[1]):
                self.swap(nums, 0, 1)
        for i in range(len(nums) - 2):
            if(i%2==0): # small large small
                if(nums[i] > nums[i+1]):
                    self.swap(nums, i, i+1)
                if(nums[i+1] < nums[i+2]):
                    self.swap(nums, i+1, i+2)
            else: # large small large
                if(nums[i] < nums[i+1]):
                    self.swap(nums, i, i+1)
                if(nums[i+1] > nums[i+2]):
                    self.swap(nums, i+1, i+2)
                
    def swap(self, nums: List[int], idx1: int, idx2: int):
        tmp = nums[idx1]
        nums[idx1] = nums[idx2]
        nums[idx2] = tmp