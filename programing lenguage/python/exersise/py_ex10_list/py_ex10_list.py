print("defined list and print item")
student = [
   {"name":"ahnet", "score": 25},
   {"name":"selin", "score": 36},
   {"name":"tuna", "score": 99},
   {"name":"ayca", "score": 55}
]
print(student[len(student)-1])
print(student[2])
# print(student[10])    eror 

print(student[1:])
print(student[2:3])
print(student[:5000])

print("chance veriable")

age = [5,26,36,18,23]
print(age)

age[0] = age[0] + 5
print(age[0])
student[0] = {"name": "dursun", "score": 79 }
print(student[0])
student[0]["score"] = 64
print(student[0])
# student[0][0] = "ceren"   not true

age[2:4]= 19, 43
print(age)

print("find list lemght")
print(len(age))
print(len(student))
print(len(student[0]))

print(" adding eleman in list")
age.append(33)
print(age)
newStudent = {"name": "lina", "score": 100}
student.append(newStudent)
print(student)

age.extend([ 0, 17])
print(age)
age.insert(0,0)
print(age)

print("delete item")
print(age)
age.remove(0)
print(age)
x = age.pop(2)
print(age)
print("deleted item",x)

print("count item")
a = [2,2,3,5,6,9,2,5]
print(a.count(2))
print(a.count(1))

print("aliasing")
b = a
a[0] = 5
print("a[0] =",a[0], ", b[0] =",b[0])


print("conbining lists")
list1 = [1,2,3]
list2 = [9,8,7]
print("list1 =",list1,", list2 = ",list2)
li = list1 + list2
print("combining list is ", li,  "\norginal list \nlist1 =",list1,", list2 = ",list2)

print("finding the index of a particular element")
print(a)
print(a.index(2))
# print(a.index(7))  take error

print("revers that lisr")
print(li)
li.reverse()
print(li ," orginal list upoud")
print(li[::-1] ,"orginal list not uploud")
print(li)

print("shorting list")
print(li)
li.sort()
print(li)
print(student)

sortStudent = sorted(student, key=lambda x: x["score"])
sortStudent.reverse()
sortStudent2 = sorted(student, key=lambda x: x["name"])
print(sortStudent)
print(sortStudent2)

c = ['a','b','2','0','w']
print(c)
c.sort()
print(c)
d = ["adem","azra","arda","aras","ali","ardacan"] 
print(d)
d.sort()
print(d)


a=20

f = 20
e = f
f = f+5
k=[20,30,40]
l2=k
k[0]=k[0]+5
print(k[0])