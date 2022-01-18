def solution(s, n):
    ans=""
    w=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    w2=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    print(len(w))
    for i in s:
        if i==" ":
            ans+=i
        elif i in w:            
            ans+=w[(w.index(i)+n)%26]
        else:
             ans+=w2[(w2.index(i)+n)%26]
    return ans
