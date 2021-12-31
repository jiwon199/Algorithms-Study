#이코테 92p 그리디 실전문제1
N,M,K=list(map(int,input().split()))
 

#연속해서 K번까지 더할 수 있고, 총 M 번 더해서 가장 큰 수. 주어지는 숫자는 N개
y=list(map(int,input().split()))
y.sort(reverse=True)

first =y[0] # 가장 큰 수
sec =y[1] # 두번째로 큰 수

#입력이 
#5 8 3
#2 4 5 4 6
#라고 할때 (6+6+6+5)가 계속 반복됨.
 
z=[]
for i in range(K):
  z.append(first)
z.append(sec) #z의 길이는 K+1

res=0 
for i in range(M):
   index=i%(K+1) #z 인덱스 초과 막기 위해
   res+=z[index]
print(res)
#--------------------모범 답안---------------------#
#더 효과적인 방법. (6+6+6+5)의 패턴을 알고있으므로 first(가장 큰수)가 총 몇 번 더해지는지, sec(두번째 큰 수)가 총 몇 번 더해지는지 
#미리 count해두면 반복문 쓸 필요없이 사칙연산만으로 값을 구할 수 있다. 

res=0  
#k+1은 반복 수열의 길이 
count=int(M/(K+1))*K #(수열 반복 횟수)*(수열 하나에 들어가는 가장 큰 수)
count+= M%(K+1) #온전히 반복되지 못하고 쪼개지는 마지막 수열이 있을 경우.. 

res=count*first+ (M-count)*sec
   
print(res)
