print("for continue - break")
for i in range(10):
   
   if (i==5):
      continue
   if (i==8):
      break
   print(i)

print("while continue - break")
i =0
while (1<5):
   print(i)
   if(i==5):
      i=i+1
      continue
   if(i==9):
      break
   
   i+=1

i=0
while(i<10):
    if(i==3 or i==5):
      continue
    print("i: ",i)
    i=i+1