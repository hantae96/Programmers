def scan(target_area,section):
    print_area = False

    while section and section[0] < target_area:
        section.pop(0)
        print_area = True
                
    if print_area:
        
        return True
    else:
        return False
        
def solution(length, roller, section):
    answer = 0
    
    ## 값을 remove 해야 되서 for 문을 쓰면 안됨
    while len(section) > 0:
        area = section[0]
        target_area = area + roller
        
        # 겹치는 영역을 검사하는 함수
        if scan(target_area,section):
            answer+=1
        
        
    return answer


n = 8
m = 4
section = [2,3,6]

print(solution(n,m,section))