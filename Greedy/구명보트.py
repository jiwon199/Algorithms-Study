import math
def solution(people, limit):
    people=sorted(people,reverse=True)
    answer=0
    left=0
    right=len(people)-1
    
    while True:
        if left>right:
            break      
        kg=people[left]+people[right]
        if kg<=limit:
            right-=1
        left+=1
        answer+=1
         
    return answer
