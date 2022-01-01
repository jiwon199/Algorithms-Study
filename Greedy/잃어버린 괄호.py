#백준 1541
import re
 
x=input()
x = re.split('([-|+])', x)
 
formula=""
for i in range(len(x)):
       if x[i]!='-' and x[i]!='+':
             x[i]=int(x[i]) #0으로 시작하는 애들을 다 일반 숫자로
       formula+=str(x[i])
reslist=formula.split('-') 
 
res=eval(reslist[0])
for i in range(1,len(reslist)):
      res-=eval(reslist[i])

print(res)
