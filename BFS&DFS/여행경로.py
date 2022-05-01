from collections import defaultdict
def solution(tickets):
    r = defaultdict(list)
     
    #i 항공에서 갈 수 있는 애들을 r[i]에 저장
    for i,j in tickets:
        r[i].append(j)
    for i in r.keys():
        r[i].sort() #i 항공에서 갈수 있는 애들을 알파벳순으로 뱉도록 정렬..

    s = ["ICN"]
    p = []
    while s:
        q = s[-1]
        #q에서 갈 수 있는 곳이 없는게 아니라면
        if r[q] != []:
            #알파벳상 가장 먼저인 놈을 append
            s.append(r[q].pop(0))  
        else:
            #갈 수 있는 곳이 없으면, 그때부터 s에 넣어놨던 애들을 꺼내면 됨. 🐶신기하네...
            p.append(s.pop())
            
    return p[::-1]
