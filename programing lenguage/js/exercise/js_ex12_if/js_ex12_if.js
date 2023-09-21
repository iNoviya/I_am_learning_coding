let temp = prompt("Please enter your exam score ")

if (temp >= 85){
   console.log(`your notes : 5 , you are best student Congratulations`)
}
else if (temp >= 70 && temp < 85){
   console.log(`your notes : 4 , you are best you will be better`)
}
else if (temp >= 60 && temp < 70){
   console.log(`your notes : 3 , you should be study`)
}
else if (temp >= 50 && temp < 60){
   console.log(`your notes : 2 , you are not bad but you should study very hard`)
}
else if (temp >= 0 && temp < 50){
   console.log(`your notes : 1 , dude, if you want to greadude you should study very hard lissten carefully lesson `)
}
else {
   console.log("wrong value")
}