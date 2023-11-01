// let item 

// item.forEach(item => console.log(item))

// let info = "this is a text for error" // this not work because it has a error
// console.log(info)

let info 
try {
   info.forEach(item => console.log(item))
}
catch (error1){
   console.log(error1)
   info = ["ayran"]
   info.forEach(item => console.log(item))
   
}

console.log("this so easy ")
