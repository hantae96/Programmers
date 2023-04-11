def solution(s):
    answer = []
    
    word = {}
    for idx,char in enumerate(s):
        if char not in word.keys():
            word[char] = idx
            answer.append(-1)
        else:
            answer.append(idx - word[char])
            word[char] = idx
    return answer