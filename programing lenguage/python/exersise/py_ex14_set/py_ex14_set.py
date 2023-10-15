s1 = {1,2,3,4,5,6}
s2 = {2,4,8,9}

print("s1 :",s1 ,"\ns2 =",s2)

print(3 in s1)

post = "hello, world"
s4 = set(post)  
print(s4)

print(len(s4))

s3 = set(s1)
print(s3)
s3.add(7)
print(s3)
s3.add(2)
print(s3)
s3.remove(3)
print(s3)
s3.discard(3) #  if its not there, there is no error
print(s3)

print("cluster")
print("differance ")

print("s1 :",s1 ,"\ns2 =",s2, "\ns3 :" ,s3)
print(s1.difference(s2),"s1-s2")
print(s2.difference(s1),"s2-s1")
print("s2-s1",s2-s3)

print("smatrict differance :",s1.symmetric_difference(s2))
print("intersection s1 s2 :", s1.intersection(s2))
print("s1 & s3 :", s1 & s3)

print("s1 , s2 conbination", s1.union(s2))

print("is disjoint",s1.isdisjoint(s2))
print("is disjoint",s1.union(s2).isdisjoint(s4))

s5 = {2,5}
print("is subset s5, s1:", s5.issubset(s1))
print("is subset : s1, s5", s1.issubset(s5))

print("is subset s5, s1:", s5.issuperset(s1))
print("is superset : s1, s5", s1.issuperset(s5))
