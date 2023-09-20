let temp = prompt("Please enter your exam score ")

if (temp >= 85){
   console.log(`your notes : 5 , you are best student Congratulations`)
}
else if (temp >= 70 && temp < 85){
   console.log("4")
}
else if (temp >= 60 && temp < 70){
   console.log("3")
}
else if (temp >= 50 && temp < 60){
   console.log("2")
}
else if (temp >= 0 && temp < 50){
   console.log("1 go to study")
}
else {
   console.log("wrong value")
}