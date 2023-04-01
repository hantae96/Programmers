def solution(babbling):
    answer = 0
    words = ["aya", "ye", "woo", "ma" ]
    for bab in babbling:
        idx = 1
        tmp = bab[0]
        check = []
        while idx<len(bab):
            if tmp in words:
                check.append(tmp)
                bab=bab.replace(bab,bab[idx:])
                idx = 0
                tmp = bab[idx]
            else:
                tmp = tmp + bab[idx]
            idx+=1
        if tmp in words:
            check.append(tmp)
            if len(check)==1:
                answer+=1
            else:
                flag = True
                for i in range(len(check)-1):
                    if check[i] == check[i+1]:
                        flag = False
                        break
                if flag:
                    answer+=1

    return answer
