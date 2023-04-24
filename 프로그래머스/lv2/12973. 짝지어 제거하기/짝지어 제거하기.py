def solution(s):
    tmp = [s[0]]
    
    for i in range(1,len(s)):
        if len(tmp) > 0:
            if tmp[-1] == s[i]:
                tmp.pop(-1)
            else:
                tmp.append(s[i])
        else:
            tmp.append(s[i])
            
    if len(tmp):
        return 0
    else:
        return 1
