let fruit = ["apple","orrang","banana","melon","stawberry","grabe","quimce"]

fruit.forEach((product,index) => console.log(product,index))

fruit.forEach((product,index,array) => array[index] = product + "_fruit")
console.log(fruit)

const ULDOM = document.querySelector('#ulList')

fruit.forEach((item,itemNumber) =>{
   let liItem = document.createElement("li")
   liItem.innerHTML =  itemNumber + "   " +item 
   ULDOM.append(liItem)
})