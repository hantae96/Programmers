from collections import defaultdict
def solution(n, words):
    
    answer = []
    word_dict = defaultdict(int)
    word_dict[words[0]] = 1
    i = 1
    
    while i<len(words):
        if words[i] not in word_dict.keys() and words[i-1][-1] == words[i][0]:        
            word_dict[words[i]] = 1
        else:
            answer.append((i%n)+1)
            answer.append((i//n)+1)
            break
            
        i+=1
        
    if len(answer) == 0:
        answer.append(0)
        answer.append(0)
    return answer