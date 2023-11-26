# Enter your code here. Read input from STDIN. Print output to STDOUT
import sys
text =[]
for line in sys.stdin:
    text.append(line)

parametry = text[0]
formula = text[1]

x1,x2 = parametry.split(" ")
x = int(x1)
x2 = int(x2)

result = eval(formula)

if (x2 == result):
    print(True)
else:
    print(False)
