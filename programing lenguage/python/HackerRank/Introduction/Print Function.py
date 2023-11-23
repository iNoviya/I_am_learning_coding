if __name__ == '__main__':
  n = int(input())
  
  def printFunction(n):
    string =""
    for i in range(n):
      string += str(i+1) 
    return string
  
  print(printFunction(n))