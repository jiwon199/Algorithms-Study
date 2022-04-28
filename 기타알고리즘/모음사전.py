from itertools import product
def solution(word):
    answer = 0
    data=['A','E','I','O','U']
     
    result=set()
    for i in range(6):
        res=list(product(data,repeat=i))
        for r in res:
            temp=""
            for i in r:
                temp+=i
            result.add(temp)
    result=sorted(result)
    for i in range(len(result)):
        if result[i]==word:
            answer=i
             
    
    return answer
