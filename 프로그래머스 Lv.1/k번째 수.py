def solution(array, commands):
    answer=[]
    temparray=array
    for i in commands:
        array =array[i[0]-1:i[1]]
        array=sorted(array)
        answer.append(array[i[2]-1])
        array=temparray
    
    return answer
