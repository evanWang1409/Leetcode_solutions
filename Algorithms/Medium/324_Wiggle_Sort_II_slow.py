"""
sort and devide into two parts
stupid method, need improvement
"""

class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nums.sort()
        smalls = nums[:math.ceil(len(nums)/2)]
        larges = nums[math.ceil(len(nums)/2):]
        smalls.reverse()
        larges.reverse()
        for i in range(len(nums)):
            if(i%2==0):
                nums[i] = smalls[int(i/2)]
            else:
                nums[i] = larges[int((i-1)/2)]