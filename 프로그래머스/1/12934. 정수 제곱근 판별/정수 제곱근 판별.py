import math

def solution(n):
    num = math.sqrt(n)
    if int(num) == num:
        answer = (num+1)**2
    else:
        answer = -1
    return answer