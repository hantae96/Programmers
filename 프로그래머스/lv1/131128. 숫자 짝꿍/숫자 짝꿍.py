from collections import Counter

def solution(X, Y):
    answer = ""
    X = Counter(X)
    Y = Counter(Y)
    tmp = []
    for i in X.keys():
        for j in Y.keys():
            if i == j:
                iter = (min(X[i],Y[j]))
                for k in range(iter):
                    tmp.append(i)
    
    tmp = sorted(list(map(int,tmp)),reverse = True)
    if len(tmp) == 0:
        return "-1"
    if sum(tmp) == 0:
        return "0"
    
    for i in tmp:
        answer = answer + str(i)

    return answer