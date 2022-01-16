def solution(numbers, hand):
    ans = ''  
    data=dict()
    index=1
    for i in range(4):
        for j in range(3):
            data[index]=[i,j]
            index+=1
    data[0]=[3,1]
    left=[3,0]  
    right=[3,2]  
    for n in numbers:         
        if n==1 or n==4 or n==7:
            ans+='L'
            left=data[n]
        elif n==3 or n==6 or n==9:
            ans+='R'
            right=data[n]
        else:
            i,j=data[n]
            lmove=abs(left[0]-i)+abs(left[1]-j)
            rmove=abs(right[0]-i)+abs(right[1]-j)
            if lmove<rmove:
                ans+='L'
                left=data[n]
            elif lmove>rmove:
                ans+='R'
                right=data[n]
            else:                 
                if hand=='left':
                    ans+='L'
                    left=data[n]
                else:
                    ans+='R'
                    right=data[n]
                
    return ans
