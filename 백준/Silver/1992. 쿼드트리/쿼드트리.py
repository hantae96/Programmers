n = int(input())
a = [list(input()) for _ in range(n)]

def quard(x, y, size):
    if size == 1:
        return a[x][y]

    b = a[x][y]
    ret = ""
    for i in range(x, x + size):
        for j in range(y, y + size):
            if b != a[i][j]:
                ret += '('
                ret += quard(x, y, size // 2)
                ret += quard(x, y + size // 2, size // 2)
                ret += quard(x + size // 2, y, size // 2)
                ret += quard(x + size // 2, y + size // 2, size // 2)
                ret += ')'
                return ret

    return a[x][y]

print(quard(0, 0, n))
