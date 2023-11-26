def count_substring(string, sub_string):
  caunt =0
  lenght = len(sub_string)
  for i in range(0,len(string)-lenght+1):
    if string[i:i+lenght] == sub_string:
      caunt +=1
  
  return caunt

if __name__ == '__main__':
    string = input().strip()
    sub_string = input().strip()
    
    count = count_substring(string, sub_string)
    print(count)