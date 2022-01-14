def solution(numbers):
    answer = [0,1,2,3,4,5,6,7,8,9]
    ans=0
    for i in range(10):
        if answer[i] in numbers:
            continue
        else:
            ans+=answer[i]
    
    return ans
