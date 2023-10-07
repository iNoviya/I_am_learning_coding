// define array
let item = [1,2,true,"mskarats",[5,6,false]]
console.log(item)

// chamge array
item = [5,9,false,"musti"]
console.log(item)

// array find element
console.log(item[3])
console.log(item[9])
console.log(Array.isArray(item))
console.log(typeof(item))
console.log(item.length)


item = [2,8,14,"opps"]
console.log(item)

// add item
item.push("69")
console.log(item)

item.push(22,`59`,true)
console.log(item)

// add item start
item.unshift("its not true",false)
console.log(item)

// select element from end
let lastItem = item.pop()
console.log(lastItem)
console.log(item)

// select element from start
let firstItem = item.shift()
console.log(firstItem)
console.log(item)


console.log(item[0])
console.log(item[0] = true)
console.log(item[0])
console.log(item)

// coppy array
item.splice(2,5)
console.log(item)

let idNummer = [2,9,22]
let userName = ["selin","hümeyra","arda"]

// add array 
item.push(userName)
item.unshift(idNummer)
console.log(item)

console.log(item[0])
console.log(item[0][1])

// coppy array
let item2 = item.splice(3,2)
console.log(item2)
console.log(item)

console.log(item.indexOf(2))

let copyItem = item
item.pop()
console.log(item)
console.log(copyItem)


let copyItem2 = item.slice()
copyItem2.shift()
console.log(copyItem2)
console.log(item)

let copyItem3 = [...item]
copyItem3.push("is yes",true,33)
console.log(copyItem3)
console.log(item)

// transform string element
console.log(copyItem2.toString()) 

console.log(copyItem3.join(" -a- "))

// add item every vere in array
item.splice(length-1,0,"arda")
console.log(item)
item.splice(1,0,"selda")
console.log(item)

//concat
let allArray = item.concat(item2.concat(copyItem3)) 
console.log(allArray)

// include
console.log(item.includes("arda"))
console.log(item.includes(false))


// fuction array
// array.forEach(element => {
// });
// .include() // is there
// .map()  //
// .some() 
// .every()  // check rule
// .filter()
// .find() 
// .sort() 
// .reduce()

