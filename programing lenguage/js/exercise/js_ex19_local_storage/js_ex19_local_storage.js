localStorage.setItem("firstName", "Adam");
localStorage.setItem("lastName", "BLACKSTONE")

console.log(localStorage.getItem("firstName"),localStorage.getItem("lastName"))

let user = {userName : 'mustafa', isActive : true }
let number = '22'

localStorage.setItem('userInfos',JSON.stringify(user))

let userInfo = localStorage.getItem('userInfos')
console.log(userInfo)
userInfo = JSON.parse(userInfo)
console.log(userInfo)

