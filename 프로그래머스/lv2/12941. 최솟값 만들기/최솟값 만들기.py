def solution(A,B):
    answer = 0

    A = sorted(A)
    B = sorted(B)
    
    
    # 비효율 정렬 하고 순차적으로 뽑는게 빠를듯
    while A:
        min_value = A.pop(0)
        max_value = B.pop(-1)
        answer += (min_value*max_value)
                
    return answer