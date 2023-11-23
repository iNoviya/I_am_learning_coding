x = int(input("enter x's value : "))
y = int(input("enter y's value : "))
z = int(input("enter z's value : "))
greater =0
middle = 0
lesser =0
if ( x >y):
   greater = x
   lesser = y
else:
   greater = y
   lesser = x

if (z > greater):
   middle = greater
   greater = z
else:
   if(z > lesser):
      middle = z
   else:
      middle = lesser
      lesser = z

print(greater,middle,lesser)

