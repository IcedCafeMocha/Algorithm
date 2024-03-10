T = int(input())     # 테스트 케이스의 개수 T 입력
f1 = []
f2 = []
f3 = []
result = []
for i in range(T):       # 입력받은 T 만큼 반복
    a = input()          # 테스트 케이스 입력
    f1 = a.split()       # ' '를 기준으로 나눈다. ex) "1 2 3 4 5" -> ['1', '2', '3', '4', '5']
    f2 = list(map(lambda x: int(x), f1))     # 정수로 변환. -> [1, 2, 3, 4, 5]
    result.append(sum(filter(lambda x: x%2 != 0, f2)))     # 홀수인 수만 뽑아 리스트로 만들어 리스트 f 안에 넣는다. -> f = [[1, 2, 3, 4, 5], ... ,]
    
for i in range(T):     # 주어진 테스트 케이스의 개수만큼 반복
    print(('#%d %d')%(i+1, result[i]))     # 요구되는 형태로 결과값 출력
