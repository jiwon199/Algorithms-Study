def solution(A,B):
    answer = 0

    A=sorted(A)
    B=sorted(B,reverse=True)
    n=len(A)
    for i in range(n):
        answer+=A[i]*B[i]

    return answer
