x=int(input())
x=1000-x
count=0

coin_types=[500,100,50,10,5,1]

for coin in coin_types:
    count += x//coin
    x%=coin
    
print(count)
