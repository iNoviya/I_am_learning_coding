if __name__ == '__main__':
    N = int(input())
    output =[]
    for i in range(N):
        x = input()
        part= x.split()
        if(part[0]=="insert"):
            output.insert(int(part[1]),int(part[2]))
        elif(part[0]=="append"):
            output.append(int(part[1]))
        elif(part[0]=="print"):
            print(output)
        elif(part[0]=="remove"):
            output.remove(int(part[1]))
        elif(part[0]=="sort"):
            output.sort()
        elif(part[0]=="pop"):
            output.pop()
        elif(part[0]=="reverse"):
            output.reverse()
