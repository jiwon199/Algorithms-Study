def solution(lottos, win_nums):
    answer = []
    rank=[6,6,5,4,3,2,1]
    counts=lottos.count(0)
    ans=0
    for a in lottos:
        if a in win_nums:
            ans+=1
            
    answer.append(rank[ans+counts])
    answer.append(rank[ans])
     
    return answer
