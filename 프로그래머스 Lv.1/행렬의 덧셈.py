def solution(arr1, arr2):     
    a=len(arr1)
    b=len(arr1[0])
    answer = [[] for _ in range (a)]      
    for i in range (a):
        for j in range(b):
            answer[i].append(arr1[i][j]+arr2[i][j])       
    return answer
