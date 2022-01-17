def solution(arr, divisor):
    answer = []
    for a in arr:
        if a%divisor==0:
            answer.append(a)
    answer=sorted(answer)
    if len(answer)==0:
        answer.append(-1)
    return answer
