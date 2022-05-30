graph=[]
temp=[]
def rotate(query):
     
    y1=query[0]
    x1=query[1]
    y2=query[2]
    x2=query[3]
    
    graph[y1-1][x1-1]=temp[y1][x1-1]
    graph[y1-1][x2-1]=temp[y1-1][x2-2]
    graph[y2-1][x1-1]=temp[y2-1][x1]
    graph[y2-1][x2-1]=temp[y2-2][x2-1]
    
    data=set()
    data.add(temp[y1][x1-1])
    data.add(temp[y1-1][x2-2])
    data.add(temp[y2-1][x1])
    data.add(temp[y2-2][x2-1])
    #1행 애들
    for i in range(x1,x2):
        graph[y1-1][i]=temp[y1-1][i-1]
        data.add(temp[y1-1][i-1])
    
    #마지막 열 애들
    for i in range(y1,y2):
        graph[i][x2-1]=temp[i-1][x2-1]
        data.add(temp[i-1][x2-1])
    
    #마지막 행 애들
    for i in range(x1,x2-1):
        graph[y2-1][i]=temp[y2-1][i+1]
        data.add(temp[y2-1][i+1])
    #1열 애들
    for i in range(y1,y2-1):
        graph[i][x1-1]=temp[i+1][x1-1] 
        data.add(temp[i+1][x1-1] )
        
    data=sorted(data)
    return data[0]
def adjust(rows,columns):
    for i in range(rows):
        for j in range(columns):
            temp[i][j]=graph[i][j]
def solution(rows, columns, queries):
    answer = []
     
    for i in range(rows):
        graph.append([j for j in range(columns*i+1, columns*i+columns+1)])
        temp.append([j for j in range(columns*i+1, columns*i+columns+1)])
    for query in queries:
        answer.append(rotate(query))
        adjust(rows,columns)
    return answer
