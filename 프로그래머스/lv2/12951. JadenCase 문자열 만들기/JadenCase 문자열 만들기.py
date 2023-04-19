def solution(s):
    answer = ''
    
    Flag = False
    tmp = []
    for i in range(len(s)):
        if Flag == False:
            if s[i].isdigit():
                tmp.append(s[i])
                Flag = True
            elif s[i].isalpha():
                tmp.append(s[i].upper())
                Flag = True
            else:
                tmp.append(s[i])
                Flag = False
        else:
            if s[i].isalpha():
                tmp.append(s[i].lower())
            else:
                tmp.append(s[i])
                Flag = False
                
    answer = "".join(tmp)
    return answer