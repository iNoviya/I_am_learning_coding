def fin(index):
    index.sort(key= lambda x: x[1])
    text =[]
    for i in range(len(index)-1):
        temp = index[i][1]
        temp2 = index[i+1][1]
        if temp != temp2:
            text.append(temp2)
        else:
            continue
    return text[0]
    
if __name__ == '__main__':
    note =[]
    for _ in range(int(input())):
        name = input()
        score = float(input())
        note.append((name,score))
    
    fin = fin(note)
    names = []
    for index in note:
        if index[1] == fin:
            names.append(index[0])
    names.sort()
    for i in names:
        print(i)