def solution(a, b):
    answer = 0
    if a > b:
        num1 = b
        num2 = a
    else:
        num1 = a
        num2 = b
    for i in range(num1, num2+1):
        answer += i
    return answer