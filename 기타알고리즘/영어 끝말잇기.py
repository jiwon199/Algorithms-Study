def solution(n, words):
    answer = []
    rounds=1
    person=0
    arr=[words[0]]
    for i in range(1,len(words)):
        now=words[i]
        before=words[i-1]
        if now[0]!=before[-1] or now in arr:
            person=i%n+1
            rounds=i//n+1
            break
        else:
            arr.append(now)
         
        
           
    if person==0:
        return [0,0]
    else:
        return [person,rounds]
     
