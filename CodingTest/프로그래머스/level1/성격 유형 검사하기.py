def solution(survey, choices):
    answer = ''
    score_table = [3,2,1,0,1,2,3]
    personality = {"A":0,"N":0,"C":0,"F":0,"M":0,"J":0,"R":0,"T":0}

    for exam in zip(survey,choices):
        test = exam[0]
        choice=exam[1]

        if choice > 3 :
            personality[test[1]] += score_table[choice-1]
        else:
            personality[test[0]] += score_table[choice-1]
    
    print(personality)
    return answer




survey = ["AN", "CF", "MJ", "RT", "NA"]
choices = [5,3,2,7,5]

print(solution(survey,choices))
