import math
def prime_list(n):
    # 에라토스테네스의 체 초기화: n개 요소에 True 설정(소수로 간주)
    sieve = [True] * n

    #m = int(n ** 0.5)
    m=int(math.sqrt(n))
    for i in range(2, m + 1):
        if sieve[i] == True:           # i가 소수인 경우 
            for j in range(i+i, n, i): # i이후 i의 배수들을 False 판정
                sieve[j] = False

    # 소수 목록 산출
    return [i for i in range(2, n) if sieve[i] == True]
n=int(input())
m=int(math.sqrt(n))
sosu=prime_list(n+1)
if n==1:
  print(0)
else:
  end=0
  val=sosu[0]
  count=0
  k=len(sosu)

  for start in range(k):   
    while val<n:
      end+=1
      if end>=k:
        break
      val+=sosu[end]
    if val==n  :
      count+=1
     
    val-=sosu[start]
  print(count)


