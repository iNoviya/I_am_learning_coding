// change last child

let item = document.querySelector(`ul#list>li:last-child`)
console.log(item)
console.log(item.innerHTML)
item.innerHTML = `${item.innerHTML} is change that : Selin`

// changed first child 
let firstChild = document.querySelector(`ul#list>li:first-child`)
console.log(firstChild)
console.log(firstChild.innerHTML)
firstChild.innerHTML = `${firstChild.innerHTML} is changed that : Kader`

// add new item
let ulDOM = document.querySelector(`ul#list`)
let liDOM = document.createElement(`li`)

liDOM.innerHTML = `adding item selma`
ulDOM.append(liDOM)
console.log(ulDOM.lastChild.innerHTML)

let liDOM2 = document.createElement(`li`)
liDOM2.innerHTML = `arzu`
ulDOM.prepend(liDOM2)