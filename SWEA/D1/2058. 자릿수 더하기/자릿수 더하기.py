#N = int(input('자연수 N을 입력하시오.(단, N은 1부터 9999까지의 자연수): '))
N = int(input( ))
if(N>9999 or N<1): #제약 사항
    exit()
temp = 0
t = len(str(N))
for i in range(t):
    temp += N//(10**(t-1-i))
    N=N%(10**(t-1-i))
    

print(temp)

