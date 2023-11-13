numbers  = []
square = []
for i in range(1,11):
   numbers.append(i)
   square.append(i**2)

print(numbers)
print(square)

square = [i**2 for i in range(1,11)]

evenSquare = [i**2 for i in range(1,11) if (i %2 ==0)] 
print("even numbers square =",evenSquare)

def takeOddSquare(x):
   if (x%2 ==1):
      return True
   else:
      return False

oddSquare = [i**2 for i in range(1,11) if(takeOddSquare(i))]
print("odd numbers squre is =",oddSquare)

list1 = [1,2,4,6,8,9,1,3,2,6,9,8]

set1 = {i for i in list1 if i in list1 }
print("set1 elemans are ",set1)
list1.append(5)
print("set1 elemans are ",set1)

dict1 = {i:i**2 for i in numbers}
print("dict1 elemans is ",dict1)

# nested list comprehension
nList = [[j for j in range(1,i+1)] for i in range(1,5)]
print("nlist is ",nList)

# i dont kmow this name 
newNlist =[]
for i in nList:
   for j in i:
      newNlist.append(j)
print("new list is ", newNlist)
set2 = [e for l in nList for e in l]
print("set2 is ",set2)

newDuzList = [[j for j in i] for i in nList  ]
print("newDuzList =",newDuzList)
