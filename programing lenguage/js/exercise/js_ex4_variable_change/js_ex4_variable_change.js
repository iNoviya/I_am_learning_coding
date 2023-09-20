let id = "326ahmet";
let price = 256;
let hasPassword = true;

console.log(
   "price type is ",
   typeof(price)
);

console.log(
   "id type is ", 
   typeof(id)
);
console.log("variables",id,price,hasPassword)

let number1 = 12;
number1 = parseInt(number1)
console.log("number1", number1,typeof(number1));

let number2 = "13asd";
number2 = parseInt(number2)
console.log("number2", number2, typeof(number2))

let number3 = "asdsad56";
number3 = parseInt(number3)
console.log("number3",number3,typeof(number3))

let number4 = "25.123dasdsad"
number4 = parseFloat(number4)
console.log("number4",number4,typeof(number4))

let test = "1325test"
test =test.toString()
console.log(test,typeof(test))

console.log("number" + 15 + 3) 

//1
console.log("foo" + +"bar")
//2
console.log('true' == true)
//3
console.log(null=="")
//4
console.log(0 || " 0" && {})
//5
console.log(["a"] > null)