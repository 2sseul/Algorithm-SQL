def solution(n):
    answer = 0
    N = str(n)
    for i in range(0, len(N)):
        answer += int(list(N)[i])
    return answer