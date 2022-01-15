from itertools import permutations
def solution(numbers):
    
    array=[]
    data=list(permutations(numbers,2))
     
    for i in range(len(data)):
        array.append(data[i][0]+data[i][1])
    array=list(set(array))
    array=sorted(array)
    return array
