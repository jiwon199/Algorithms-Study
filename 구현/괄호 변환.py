import sys
sys.setrecursionlimit(10**8)
def devide(p):
    stack=[p[0]]
    index=1
    while True:
        if len(stack)==0:
            break
        if p[index]==p[0]:
            stack.append(p[index])
        else:
            stack.pop(0)
        index+=1
    #잘라야 하는 인덱스를 반환            
    return index  
def isCorrect(p):
    #(를 넣고, )를 뺀다. 연산이 끝났을때 스택이 비었고, 중간에 빈 스택에서 빼지 않아야 올바름.
    flag=True
    stack=[]
    for i in range(len(p)):
        if p[i]=='(':
            stack.append('(')
        else:
            if len(stack)==0:
                flag=False
            else:
                stack.pop(0)
    if len(stack)!=0:
        flag=False
                            
    return flag
def reverse(p):
    temp=''
    for i in p:
        if i=='(':
            temp+=')'
        else:
            temp+='('
    return temp
def makeCorrect(p):
    if p=='':
        return p
    index=devide(p)
    u=p[:index]
    v=p[index:]
    if isCorrect(u)==True:
        #answer+=u
        return u+makeCorrect(v)
    else:         
        temp='('+makeCorrect(v)+')'+reverse(u[1:-1])         
        return temp
        
def solution(p):
    answer = ''
    res=makeCorrect(p)   
    return res
