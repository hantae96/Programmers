last_idx = 0

def check(cook):
    if cook[-4:] == [1,2,3,1]:
        for _ in range(4):
            cook.pop()
        return True
    return False

def solution(ingredient):
    answer = 0
    cook = []
    # 빵이 들어왔는데 완성이 안되면 다 버린다.

    for i in ingredient:
        cook.append(i)
        if check(cook):
            answer+=1
            
    return answer

ingredient = [1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1, 2, 3, 1, 3, 3, 3, 2, 1, 2, 3, 1]
print(solution(ingredient))