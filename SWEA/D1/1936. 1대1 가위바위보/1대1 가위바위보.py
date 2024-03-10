t = input()
p = t.split(' ')
a = int(p[0])
b = int(p[1])

if(a==1):
    if(b==2):
        print('B')
    elif(b==3):
        print('A')
if(a==2):
    if(b==1):
        print('A')
    elif(b==3):
        print('B')
if(a==3):
    if(b==1):
        print('B')
    elif(b==2):
        print('A')