import heapq
def solution(jobs):
    answer = 0
    q=[]
    n=len(jobs)
    jobs=sorted(jobs)
    #큐에 (소요시간0, 요청시간1, 대기시간2, 처리시간3)으로 넣기. 총 시간은 대기시간+소요시간
    time=jobs[0][0]
    heapq.heappush(q,[jobs[0][1],jobs[0][0],0,0])
    jobs.pop(0)
    workTime=0
    nowWork=[]
    while True:
        if len(q)==0 and len(jobs)==0 and len(nowWork)==0:
            break
        newJobs=[]
        for job in jobs:
            if time>=job[0]:
                heapq.heappush(q,[job[1],job[0],0,0])
            else:
                newJobs.append(job)
        jobs=newJobs
        
        #작업이 끝났고 대기중인 애가 있으면 걔를 작업하자
        if len(nowWork)==0 and len(q)>0:
            nowWork=heapq.heappop(q)
        #현재 작업할 애를 처리
        if len(nowWork)==4:
            for work in q:
                work[2]+=1
            nowWork[3]+=1 # 현재 작업할 애 처리시간+=1
            if nowWork[0]==nowWork[3]: #작업이 완료됐으면 시간 더하기 
                workTime=workTime+nowWork[0]+nowWork[2]
                nowWork=[]     
        time+=1
    
    return workTime//n
