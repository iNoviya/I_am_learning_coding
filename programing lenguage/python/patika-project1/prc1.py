# problem 1 
input = [[1,'a',['cat'],2],[[[3]],'dog'],4,5]
# problem 2
input2 = [[1, 2], [3, 4], [5, 6, 7]]

# solision pronblem 1
def listLine(tamplate):
   output = []

   for e in tamplate:
      if (isinstance(e, (int,str))):
         output.append(e)
      else:
         if (len(e) ==0):
            break
         listLine(e)
   return output

# solision pronblem 2
def reverseList(input2):
   input2.reverse()  # Ana listenin elemanlarını tersine döndür
   for i in range(len(input2)):  # Listenin her elemanını kontrol et
      if isinstance(input2[i], list):  # Eğer eleman bir liste ise
         input2[i] = reverseList(input2[i])  # İçindeki listeyi de tersine döndür
   return input2



print(f"This is the solution to the problem 1 \n{listLine(input)} ")
print(f"This is the solution to the problem 1 \n{reverseList(input2)} ")
