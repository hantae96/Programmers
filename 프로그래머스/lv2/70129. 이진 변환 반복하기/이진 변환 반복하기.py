def solution(s):
    answer = []
    change_count = 0
    zero_count = 0
    
    while s != "1":
        tmp = 0
        for i in s:
            if i == "1":
                tmp+=1
        
        zero_count += len(s) - tmp
        s=str(bin(tmp)[2:])
        change_count+=1
    answer = [change_count,zero_count]
    return answer