def getNum(big,small):
    if big<small:
        big,small=small,big
    n=big
    while True:
        if n%small==0:
            break
        n+=big
    return n
def solution(arr):
    while True:
        if len(arr)==1:
            break
        new=getNum(arr[0],arr[1])
        arr.append(new)
        arr.pop(0)
        arr.pop(0)
    return arr[0]
