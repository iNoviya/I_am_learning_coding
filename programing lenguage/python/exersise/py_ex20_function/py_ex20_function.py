def square(x):
   # take square
   return x**2

print ("square of 2 =",square(2))
print( "square of (suquare of 2) =",square(square(2)))


aList = [1,3,6,8]
outputList = []


for e in aList:
   outputList.append(square(e))
   
print("outputs List event's are :",outputList)

# 
def printHello():
   print("hello")
printHello()
print("learn type of function")
print("square funcsion's type is :",type(square(2)))
print("printHello funcsion's type is :",type(printHello()))


# more than one input and output
def sum(x,y):
   total = x+y
   return x,y,total

a,b,tot = sum(3,5)
print("a =",a,", b =",b,", a+b =",tot)


# Predefined parameters
def email(userName ,domain="mskarats.com"):
   return print("your email is",userName+"@"+domain)

print("Predefined parameters")
email("mskarats98","gmail.com")
email("3",)
email("")

def power (x,y=1):
   return print(x,"power to ",y," =", x**y)

power(3,)
power(3,4)

print("first class function")
powerOfTwo = square
print(powerOfTwo(3))
