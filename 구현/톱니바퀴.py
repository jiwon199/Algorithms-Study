#백준 14891
def turn(index,direction):
  rotate[index]=True
  #왼쪽을 확인
  if index!=0:
    if saw[index][-2]!=saw[index-1][2] and rotate[index-1]==False:
      turn(index-1,reverse(direction))
  #오른쪽을 확인
  if index!=3 and rotate[index+1]==False:
    if saw[index][2]!=saw[index+1][-2]:
      turn(index+1,reverse(direction))
  
  #반시계면 
  if direction==-1:
    saw[index].append(saw[index][0])
    saw[index]=saw[index][1:]
  #시계면
  else:
    temp=saw[index][-1]
    saw[index]=saw[index][:7]
    saw[index].insert(0,temp)
     
   
saw=[]
for _ in range(4):
  temp=list(map(int,list(input())))
  saw.append(temp)

def reverse(direction):
  if direction==1:
    return -1
  else:
    return 1
    
k=int(input())
for i in range(k):
  num,dir=list(map(int,input().split()))
  rotate=[False,False,False,False]
  turn(num-1,dir)
 
#점수 계산
answer=0
if saw[0][0]==1:
  answer+=1
if saw[1][0]==1:
  answer+=2
if saw[2][0]==1:
  answer+=4
if saw[3][0]==1:
  answer+=8
print(answer)
  
