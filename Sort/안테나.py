#백준 18310
import sys
 
n=int(sys.stdin.readline())
home=list(map(int,sys.stdin.readline().split()))
home=sorted(home)

print(home[(n-1)//2])
