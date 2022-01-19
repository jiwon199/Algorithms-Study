def solution(s):
    answer=''
    i=0
    for k in s:
        if k==' ':
            i=0
            answer+=k
        else:           
            if i%2==0:
                answer+=k.upper()
            else:
                answer+=k.lower()
            i+=1
    return answer
