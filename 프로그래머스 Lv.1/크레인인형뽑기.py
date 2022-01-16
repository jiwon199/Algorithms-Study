def popDoll(doll,basket,poped):
    l=len(basket)    
    if l>0:
        if basket[l-1]==doll:
            poped.append(basket[l-1])
            poped.append(doll)
            basket.pop(l-1)
             
        else:
            basket.append(doll)
             
    else:
        basket.append(doll)
         
    
def solution(board, moves):    
    n=len(board)
    b=[[] for _ in range(n)]
    basket=[]
    poped=[]
    for i in range(n):
        for j in range(n):
            b[i].append(board[j][i])
    count=0   
    for i in moves:
        for j in range(n):            
            if b[i-1][j]!=0:                  
                popDoll(b[i-1][j],basket,poped)
                b[i-1][j]=0
                break
            else:
                continue   
    ans=len(poped)   
    return ans
