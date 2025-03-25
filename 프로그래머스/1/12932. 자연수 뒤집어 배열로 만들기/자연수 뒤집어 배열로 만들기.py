def solution(n):
    answer = []
    N = str(n)
    tmp = list(''.join(reversed(N)))
    
    for i in range(0, len(N)):
        answer.append(int(tmp[i]))
    
    return answer