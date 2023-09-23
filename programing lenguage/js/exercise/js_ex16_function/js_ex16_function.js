// name foncsion
let firstName = prompt("what is your name")
let sureName = prompt(" what is your surename")

function fullName (fName="userName",sName="userSurname"){
   let fullName =`hello ${firstName} ${sureName.toUpperCase()}`
   return fullName
}
let allName = fullName(firstName,sureName)
console.log(allName)

// addition funcsion
function addition (number1,number2) {
   let addition = number1 + number2
   return(console.log(`${number1} + ${number2} = ${addition}`))
} 
addition(5,3)


// subtraction function
function sub (number1,number2){
   let subtraction = number1 - number2
   return subtraction 
}
let subtraction = sub(5,3)
console.log(subtraction)


// printing html file 
function printing (word,hactage){
   let info = document.querySelector(`#${hactage}`)
   info.innerHTML = word
}
printing(`I LOVE CODIG`,`words`)
printing(allName,`name`)


// Arrow function 
function hello(firstName) {
   console.log(`${firstName} BLACKSTONE`)
}
hello(`ahmet`)

const helloArrow = (firstName) => {console.log(`${firstName} BLACKSTONE`)}
helloArrow(`Mustafa`)

const helloArrow2 = firstName => console.log(`${firstName} BLACKSTONE`)
helloArrow2(`Selma`)

const helloArrow3 = (firstName, lastName)  => 
console.log(`${firstName}  ${lastName}`)
helloArrow3(`Asli`, `KOC`)

const helloArrow4 = (firstName,lastName) =>{
   let info = `dear ${firstName}  ${lastName}`
   console.log(info)
   return info
}
helloArrow4(`selvi`,`maxx`)