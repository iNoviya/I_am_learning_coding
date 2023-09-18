// take all information about h2 
let title = document.getElementsByTagName("h2")
console.log(title)

title = document.getElementById(`titleh2`)
console.log(title)
console.log(title.innerHTML)

let listItem = document.querySelector(`ul#list>li`)
console.log(listItem)
console.log(listItem.innerHTML)
console.log(listItem.innerHTML = `Changes list iteö`)
listItem.style.color = `red`
listItem.classList.add("btn")
