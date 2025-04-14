def solution(numbers):
    arr = list(range(0, 10))
    answer = 0
    num = len(numbers)
    for i in range(0, num):
        if numbers[i] in arr:
            arr.remove(numbers[i])
    for i in range(0, len(arr)):
        answer += arr[i]
    return answer