from collections import defaultdict

def solution(clothes):
    answer = 1
    cloth_set = defaultdict(list)
    for i in clothes:
        cloth_set[i[1]].append(i[0])
    
    for key in cloth_set.keys():
        answer *= len(cloth_set[key]) + 1
        
    return answer-1