import sys
sys.setrecursionlimit(10**6)
def find_room(chk,key,room):
    #방이 비었으면
    if chk not in key:
        room[chk]=chk+1 #chk는 chk+1번부터 확인해라
        return chk
    
    empty=find_room(room[chk],key,room)
    # 빈방이 나오기 전 방문했던 부모 노드 바꿔줌
    room[chk]=empty+1 #chk는 empty+1번방부터 확인해라
    return empty

        
    return chk
          
def solution(k, room_number):
    answer = []
    room=dict()   
    key=room.keys()
    for i in room_number:
        chk=find_room(i,key,room)
        answer.append(chk)
    return answer
