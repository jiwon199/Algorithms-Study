from collections import defaultdict
from string import ascii_lowercase
def makeSet(strs):
    arr=[]
    alpha = list(ascii_lowercase)
    for i in range(len(strs)-1):
        temp=strs[i]+strs[i+1]
        if strs[i] in alpha and strs[i+1] in alpha:
            arr.append(temp)
    return arr
def makeData(str_set,data):
    for word in str_set:
        data[word]=data[word]+1
def solution(str1, str2):
    answer = 0
    str1_data=defaultdict(int)
    str2_data=defaultdict(int)
    str1=str1.lower()
    str2=str2.lower()
    
    str1_set=makeSet(str1)
    str2_set=makeSet(str2)
    makeData(str1_set,str1_data)
    makeData(str2_set,str2_data)
    
    str_set=set()
    for word in str1_set:
        str_set.add(word)
    for word in str2_set:
        str_set.add(word)
     
    hap=0
    kyo=0
    for word in str_set:
        hap+=max(str1_data[word],str2_data[word])
        kyo+=min(str1_data[word],str2_data[word])
    
     
    if hap==0 and kyo==0:
        return 65536
    else:
        return int(kyo/hap*65536)
     
