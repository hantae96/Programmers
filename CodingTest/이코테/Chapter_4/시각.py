import datetime as dt

n = 5
ans1 = 0
for hour in range(n+1):
    for min in range(60):
        for sec in range(60):
            if "3" in str(sec) + str(min) + str(hour):
                ans1 +=1

print(ans1)

ans = 0
for hour in range(n+1):
    if "3" in str(hour):
        ans +=1
    for min in range(60):
        if "3" in str(sec):
            ans +=1
        for sec in range(60):
            if "3" in str(sec):
                ans +=1

print(ans1/ans)
