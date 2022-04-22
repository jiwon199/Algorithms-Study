import re
import copy
def isOper(oper,expression):
    flag=False
    for ex in expression:
        if ex==oper:
            flag=True
    return flag
def cal(index,oper,expression):
    num=eval(expression[index-1]+oper+expression[index+1])
    temp=[]
    for i in range(len(expression)):
        if i==index:
            temp.append(str(num))
        elif i==index-1 or i==index+1:
            continue
        else:
            temp.append(expression[i])
    return temp

def calculate(oper,expression):
    while True:
        flag=True
        l=len(expression)
        for i in range(l):
            if expression[i]==oper:
                expression=cal(i,oper,expression)              
                flag=False
                break
        if flag==True:
            break
    return expression
                       
def solution(expression):
    answer = 0
    operOrder=[ ('+','-','*'),
        ('+','*','-'),
        ('*','+','-'),
        ('*','-','+'),
        ('-','+','*'),
        ('-','*','+') 
              ]
    expression=re.split('([-|+|*])',expression)
    print(expression)
    result=[]    
    for opers in operOrder:
        stack=copy.deepcopy(expression)
        for oper in opers:
            stack=calculate(oper,stack)
        result.append(abs(int(stack[0])))
    
    return max(result)
