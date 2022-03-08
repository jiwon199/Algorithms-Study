#백준 2607
def counting(ar, word) :
    for w in word : 
        i=ord(w) - ord('A')
        ar[i] += 1
 
 
n=int(input())
words=[]
for i in range(n):
  words.append(input())
  
answer =0
diff =0 #두 단어간의 알파벳 차이     
freq_firstword=[0] *26 
length = len(words[0]) #첫 번째 단어 길이
 
counting(freq_firstword, words[0]) #첫 번째 단어 알파벳 개수 세기
   
for i in range(1,n) :
  diff =0
  freq_other=[0] * 26        
  counting(freq_other, words[i]) #다른 단어 알파벳 개수 세기
    
  #두 단어간의 알파벳 차이 계산
  for freq1, freq2 in zip(freq_other, freq_firstword) :
    diff += abs(freq1-freq2)            
        
  #비슷한 단어의 조건을 코드로 표현
  if (diff==0 or diff ==1 or (diff==2  and (len(words[i]) == length))) :  
    answer +=1
    
print(answer)
  
