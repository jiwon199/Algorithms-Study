from collections import deque
 
def makeData(index,data,words):
    current=words[index]
    for i in range(len(words)):
        word=words[i]
        if word!=current:
            cnt=0
            for j in range(len(word)):
                if word[j]!=current[j]:
                    cnt+=1
            if cnt==1:
                data[index].append(i)
    return
def solution(begin, target, words):
    answer = 0
     
    words.append(begin)
    data=[[] for i in range(len(words))]
    startIndex=0
    for i in range(len(words)):
        if words[i]==begin:
            startIndex=i
         
        makeData(i,data,words)
            
    visited=[False for i in range(len(words))]
    queue=deque()
    queue.append([startIndex,0])
    visited[startIndex]=True
     
    while queue:
        index,count=queue.popleft()
        if words[index]==target:
            answer=count 
            
            break
        
        for i in data[index]:
            if visited[i]==False:
                visited[i]=True
                queue.append([i,count+1])
    
    return answer
