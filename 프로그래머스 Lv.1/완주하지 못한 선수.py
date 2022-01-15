def solution(p, c):
    dataC=dict()
    for n in c:
        if n in dataC.keys():
            dataC[n]=dataC[n]+1
        else:
            dataC[n]=1
    dataP=dict()
    for n in p:
        if n in dataP.keys():
            dataP[n]=dataP[n]+1
        else:
            dataP[n]=1
            
    key_P=dataP.keys()
    key_C=dataC.keys()
    for key in key_P:
        if key in key_C:
            if dataC[key]!=dataP[key]:
                answer=key
        else:
            answer=key
    return answer
    
#고수의 풀이
def solution(participant, completion):
    participant.sort()
    completion.sort()
    for p, c in zip(participant, completion):
        if p != c:
            return p
    #for문 다돌고도 못찾으면 마지막에 있는애가 답 
    return participant[-1]
