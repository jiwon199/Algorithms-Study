from itertools import permutations
def isSame(user,ban):
    flag=True
    if len(user)!=len(ban):
        flag=False
    else:
        l=len(user)
        for i in range(l):
            if ban[i]!="*":
                if ban[i]!=user[i]:
                    flag=False
    return flag

#콤비에 있는 애들이 밴 아이디에 있는 애들이랑 맞아떨어지는지 확인 
def check(combi,banned_id):
    flag=True
    l=len(banned_id)
    for i in range(l):
        if isSame(combi[i],banned_id[i])==False:
            flag=False
    return flag
  
def solution(user_id, banned_id):    
    result=list(permutations(user_id,len(banned_id)))
    data=set()
    for combi in result:
        if check(combi,banned_id)==True:
            combi=sorted(combi)
            data.add(tuple(combi)) 
    return len(data)
