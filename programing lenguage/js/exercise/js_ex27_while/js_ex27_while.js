let counter =0

while (1<2){
   if (counter == 5) break
   else{
      console.log(counter)
      counter = counter+1
   }
}
let n = 3
do [
   n = 2*n
]
while(n<200){
   console.log(n)

}




let userName

while (!userName){
   userName = prompt("write your name")
   if (userName !== null && userName == ""){
      continue
   }
   else{
      console.log(userName)
   }
}

