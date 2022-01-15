def solution(sizes):
     
    for s in sizes:
        if s[0]<s[1]:
            s[0],s[1]=s[1],s[0]
    w=0
    h=0
    for s in sizes:
        if s[0]>w:
            w=s[0]
        if s[1]>h:
            h=s[1]
            
    return (w*h)
