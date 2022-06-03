def solution(skill, skill_trees):
    answer = 0
    order=[]
    visited=[]
    data=dict()
    n=len(skill)
    for i in range(n):
        order.append(skill[i])
        data[skill[i]]=i
        
    cleared_skill=[]
    for skills in skill_trees:
        temp=''
        for i in range(len(skills)):
            if skills[i] in order:
                temp+=skills[i]
        cleared_skill.append(temp)
    
    for word in cleared_skill:
        flag=True
        visited=[False]*n
        for i in range(len(word)):
            if data[word[i]]==0:
                visited[0]=True
            else:
                if visited[data[word[i]]-1]==True:
                    visited[data[word[i]]]=True
                else:
                    flag=False
        if flag==True:
            answer+=1
        
    return answer
