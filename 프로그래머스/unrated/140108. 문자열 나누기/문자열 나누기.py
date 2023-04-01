from collections import defaultdict

def solution(s):
    answer = 0
    word_table = defaultdict(int)
    s = list(s)
    check = True
    for idx,word in enumerate(s):
        if check:
            x = word
            word_table[x] +=1
            check = False
        else:
            word_table[word] +=1
            keys = list(word_table.keys())
            
            tmp = 0
            for key in keys:
                if key != x:
                    tmp += word_table[key]
            if word_table[x] == tmp:
                answer +=1
                word_table = defaultdict(int)
                check = True

        if idx == (len(s))-1 and len(word_table.keys())>0:
            answer+=1
            
    return answer