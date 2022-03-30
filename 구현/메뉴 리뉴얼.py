def solution(orders, course):
    answer = []
    arr=[dict() for _ in range(course[-1]+1)]
     
    data=dict()
      
    for order in orders:
        for n in course:
            temp=list(combinations(order,n))
            for tuple in temp: 
                word=[]
                for w in tuple:
                    word.append(w)
                word=sorted(word)
                t=''
                for w in word:
                    t+=w
                    
                if t in arr[n].keys():
                    arr[n][t]+=1
                else:
                    arr[n][t]=1    
    maxAppear=[0]*(course[-1]+1)
     
    for i in range(len(arr)):
        for combi in arr[i]:
            maxAppear[i]=max(arr[i][combi],maxAppear[i])
                    
     
    for i in range(len(arr)):
        for combi in arr[i]:
            if arr[i][combi]==maxAppear[i] and maxAppear[i]>=2:
                answer.append(combi)
            
    answer=sorted(answer)
    return answer
