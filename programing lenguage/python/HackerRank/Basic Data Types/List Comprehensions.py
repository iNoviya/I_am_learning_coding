if __name__ == '__main__':
   x = int(input())
   y = int(input())
   z = int(input())
   n = int(input())
   
   listMain = []   
   for i in range(x+1):
      for j in range(y+1):
         for k in range(z+1):
               if((i+j+k !=n)):
                  listt = []
                  listt.append(i)
                  listt.append(j)
                  listt.append(k)
                  listMain.append(listt)
   print(listMain)                
                