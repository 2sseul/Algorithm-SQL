
def solution(n):
    x = 1
    while True:
        if n % x == 1:
            break
        else:
            x += 1
            continue
    answer = x
    return answer