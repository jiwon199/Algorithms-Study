def solution(cacheSize, cities):
    answer = 0
    cache=[]
    n=len(cities)
    for i in range(n):
        cities[i]=cities[i].upper()
   
    for i in range(n):
        if cities[i] in cache:
            cache.remove(cities[i])
            cache.append(cities[i])
            answer+=1
        else: 
            if len(cache)<cacheSize:
                cache.append(cities[i])
            else:                 
                cache.append(cities[i])
                cache.pop(0)
            answer+=5
                    
                  
    return answer
