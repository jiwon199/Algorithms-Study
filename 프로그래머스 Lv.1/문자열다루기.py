def solution(s):
    num=['1','2','3','4','5','6','7','8','9','0']
    if len(s)==4 or len(s)==6:
        for i in s:
            if i in num:
                continue
            else:
                return False
        return True
    else:
        return False
