T = int(input())
result = []
for i in range(T):
    t = input()
    temp = t.split()
    MAP = list(map(int,temp))
    MAP.sort()
    result.append(MAP[9])
for i in range(T):
    print('#%d %d'%(i+1, result[i]))