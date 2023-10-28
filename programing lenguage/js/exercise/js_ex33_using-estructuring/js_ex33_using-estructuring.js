let settings = {
   userName : "Mustafa",
   pasword : "123asd456",
   isActive : false,
   ip : "192.168.1.1",
   serverNane : "patika.org"
}

let userNick = settings.userName
console.log(userNick)

let {userName,pasword,isActive,ip,serverNane:server} = settings
console.log(userName,pasword,isActive,ip,server)

let {userName : nick ,pasword:pasword2,...newSetings} = settings
console.log(newSetings)

let settings3 = {...settings}
settings.userName = "mskarats"

console.log(settings)
console.log(settings3)

let id = [5,16,82,1,35]
console.log(id)
let id2 = [...id]
id[2] = 11
id[3] = 26
console.log(id)
console.log(id2)

