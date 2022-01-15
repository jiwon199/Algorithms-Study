def solution(a, b):
    month=[31,29,31,30,31,30,31,31,30,31,30,31]
    day=[ 'FRI','SAT','SUN','MON','TUE','WED','THU']
    res=0
    for i in range(a-1):
        res+=month[i]
        
    answer = day[(res+b-1)%7]
    return answer
