#백준 2210
def dfs(x,y,word):
   
  if x>=0 and y>=0 and x<5 and y<5:
  
    word+=str(graph[x][y])
    if len(word)==6:
      data.add(word)
      return word
    else:    
      return dfs(x+1,y,word),dfs(x-1,y,word),dfs(x,y+1,word),dfs(x,y-1,word)
   
data=set()
graph=[]
for i in range(5):
  graph.append(list(map(int,input().split())))
visited=[[False]*5 for _ in range(5)]
for i in range(5):
  for j in range(5):
     dfs(i,j,'')
 
print(len(data))

