from collections import deque
def check(dq):
    collect = {"[":"]","(":")","{":"}"}

    check = True
    stack = []
    for i in dq:
        if len(stack) != 0:
            if i in collect:
                stack.append(i)
            else:
                if collect[stack[-1]] == i:
                    stack.pop()
                else:
                    check = False
                    break
        else:
            if i in collect:
                stack.append(i)
            else:
                check = False
                break
                
    if check and len(stack) == 0:
        return True
    else:
        return False
    
    


def solution(s):
    answer = 0
    dq = deque()
    
    for i in s:
        dq.append(i)
    origin = dq.copy()
    
    for i in range(len(dq)):
        dq.rotate(-1)
        if check(dq):
            answer+=1 
        
    return answer