def solution(N, s):
    answer = []     
    s=sorted(s)
    user=[] #각 인덱스 스테이지에 도전한 사람수
    user.append(len(s))
    for i in range(1,N+1):
        k=s.count(i)
        if k!=0:
        	answer.append((i,k/user[i-1]))
        else:
            answer.append((i,0))
        user.append(user[i-1]-k)
         
    answer.sort(key=lambda x:(x[1]), reverse=True)
    array=[]
    for i in answer:
        array.append(i[0])
    return array
