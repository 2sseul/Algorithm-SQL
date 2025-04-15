def solution(n, arr1, arr2):
    answer = []
    # 배열로 만들기
    for i in range(0, len(arr1)):
        list1 = list(format(arr1[i], f'0{n}b'))
        list2 = list(format(arr2[i], f'0{n}b'))
        # 1인지 0인지 판단하고 지도 만들기
        tmp = ''
        for j in range(0, len(list1)):
            if list1[j] == '1' or list2[j] == '1':
                list1[j] = 1
            tmp += str(list1[j])
            
        # 1은 #으로, 0은 공백으로 대치
        tmp = tmp.replace('1','#',n)
        tmp = tmp.replace('0',' ',n)
        answer.append(tmp)
    return answer