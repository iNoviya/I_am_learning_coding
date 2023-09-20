let temp = 25
let temp2 = 30 
let temp3 = 25
console.log("temp equal = ",temp)
let user = "ali"

// it is equal?  "=="
console.log("is ",temp,"equal to 28:", temp==28)
console.log("is ",temp,"equal to 25:", temp==25)

// Are type and value equal?  "==="
console.log("this value is =",temp,"this type is = ",typeof(temp))
console.log("is ",temp,"equal to 25 (sitring veriable) :", temp==="25")
console.log("is ",temp,"equal to 28 (number veriable) :", temp===28)
console.log("is ",temp,"equal to 25 (number veriable) :", temp===25)

// not equal   "!="
console.log(temp != 1)
console.log(temp != 25)
console.log(temp != `25`)
console.log(user != "guest") 

// big and 
console.log("is",temp, "less than", temp2, "?", temp > temp2 )
console.log("is",temp, "greader than", temp2, "?", temp < temp2 )
console.log("is",temp, "big equal than", temp2, "?", temp > temp2 )
console.log("is",temp, "small equal than", temp2, "?", temp <= temp2 )
console.log("is",temp, "big equal than", temp3, "?", temp >= temp3 )

// and operatör "&&"
console.log/("and operator")
console.log( temp == 25 && user != "guest")
console.log( temp != 25 && user != "guest")
console.log( temp == 25 && user != "ali")
console.log( temp != 25 && user != "ali")
// or operator  "||"
console.log("or operatör")
console.log( temp == 25 || user != "guest")
console.log( temp != 25 || user != "guest")
console.log( temp == 25 || user != "ali")
console.log( temp != 25 || user != "ali")

// not operator  "!"
console.log("not operator")
console.log( temp == 25 && !user != "guest")
console.log( temp != 25 && !user != "guest")
console.log( temp == 25 && !user != "ali")
console.log( temp != 25 && !user != "ali")

console.log(2);