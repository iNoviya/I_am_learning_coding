studentName = "Mustafa KARATAŞ"
print(studentName)

print(studentName[5])

print(studentName[0] + studentName[8])
user1 = "arda"[2]
print(user1)
# not work
#  user2 = "selim"[8]


'wrong used'
# print(" ayten said that "she is so beautifull" ")
# print(' ali's real name is "selin" ')

' true used'
print("ayten said that 'she is so cute' ")
print("ali's real name is \" selin \" ")
print('ali\'s real name is \'selma\' ')

# len
age = "four"
name = "arzu"
userInfo = name + " is " + age + " years old "

print(len(age))
print(len(userInfo))
print(len("25") and '25 is owed 2 caracter')

# * operator in string
number = 5*("zer0 ")
print(number)

userName = "arda atmaca"
asd = slice(userName[3:8])
print(asd)
print(slice(userName[1:25:2]))
print(slice(userName[10::-1]))