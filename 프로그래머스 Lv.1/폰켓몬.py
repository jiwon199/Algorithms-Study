def solution(nums):
    n=len(nums)//2
    m=len(nums)     
    data=set([])
    index=0
    while len(data)<n:
        if index > m-1:
            break
        data.add(nums[index])
        index+=1
                                          
    return len(data)
