def solution(n, arr1, arr2):
    answer = []
    # 배열로 만들기
    for i in range(0, len(arr1)):
        binary = format(arr1[i] | arr2[i], f'0{n}b')
        binary = binary.replace('1','#',n)
        binary = binary.replace('0',' ',n)
        answer.append(binary)
    return answer