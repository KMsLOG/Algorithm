def solution(numbers, target):
    answer = 0
    ls = [0]
    for i in numbers:
        tmp =[]
        for j in ls:
            tmp.append(j+i)
            tmp.append(j-i)
        ls = tmp
    for k in ls:
        if k == target:
            answer+=1
    return answer