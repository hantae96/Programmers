import sys
sys.stdin=open("/Users/Hantae/Desktop/Dev/Programmers/CodingTest/이코테/Chapter_4/input.txt")

n,m = map(int,input().split())
start = list(map(int,input().split()))
answer = 0

game = [list(map(int,input().split())) for _ in range(n)]
check = [[0]*m for _ in range(n)]
# 왼쪽 방향으로 돌아야됨
# deque 자료구조를 쓰던가 해서 한바퀴 돌리기 
directions = [3,2,1,0]
moving = {3:(0,-1),2:(1,0),1:(0,1),0:(-1,0)}

# 처음 시작 좌표에서
# 반시계 방향 돌린 좌표를 넣고
# 방문하지 않은 곳이나, 바다가 아니라면 이동
# 아니면 다시 반시계방향 돌리기
# 다돌렸는데 갈곳이 없으면
# 처음 시작 좌표로 돌아가기.

# 바라본 방향을 유지한채로 한칸 뒤로 가고 1단계로 돌아감.
# 만약 뒤쪽방향이 바다라면 종료
# 간곳도 체크해야됨

while True:

    flag = True
    for idx,direction in enumerate(directions):
        direction_tmp = 0
        if start[2] == direction:
            # 한칸 이동
            direction_tmp = directions[(idx+1)%4]
            tmp_x = start[0]+moving[direction_tmp][0]
            tmp_y = start[1] + moving[direction_tmp][1]
            tmp_start = [tmp_x,tmp_y,direction_tmp]

            if game[tmp_x][tmp_y] != 1:
                if check[tmp_x][tmp_y] == 0:
                    check[tmp_x][tmp_y] = 1
                    start = [tmp_x,tmp_y,direction_tmp]
                    answer += 1
                    break
                else:
                    start = [start[0],start[1],direction_tmp]
                    break
            else:
                start[2] = direction_tmp
                
            
            if game[tmp_x][tmp_y] == 1 and check[tmp_x][tmp_y] == 1:
                start = [start[0]+moving[(direction_tmp+2)%4],start[1]+moving[(direction_tmp+2)%4],direction_tmp]

                if game[start[0]][start[1]] == 1:
                    flag = False
                    break
        

    if flag == False:
        break
        
print(answer)        
