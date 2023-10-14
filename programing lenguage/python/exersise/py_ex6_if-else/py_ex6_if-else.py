a = 10 
b = True
c = -4

if (a >3): 
   print("true")
else:
   print("false")

if (a > 10 & b == False):
   print("a biger than 10 and b equit false")
elif(a > 10 & b == True):
   print("all parametry true")
else:
   ("alll of wrong")

x = int(input("enter a number"))

if(x%4 == 0):
   print(" the number is divisible by 4")
elif(x%4 == 1):
   print(" the number is not divisible by 4. remainder is 1")
elif(x%4 == 2):
   print(" the number is divisible by 4. reöainder 2")
   if( x%3 == 0):
      print("the number is divisible by 3 and 4, remainder 2")
   else:
      print("its so strange number")
else:
   print("the number is divisible by 4, remainder 3")


index = input("y or n")

index if index == "y" else print("F")
print("T")