def solution(x):
    answer = True
    tmp = x
    num = 0
    while True:
        if tmp < 10:
            num += tmp
            break
        num += int(tmp%10)
        tmp = int(tmp/10)
    
    if x % num != 0:
        answer = False
        
    return answer