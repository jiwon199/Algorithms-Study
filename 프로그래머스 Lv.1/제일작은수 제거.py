def solution(arr):
    answer = arr
    arr=sorted(arr)
    answer.remove(arr[0])
    if len(answer)==0:
        answer=[-1]
    return answer
