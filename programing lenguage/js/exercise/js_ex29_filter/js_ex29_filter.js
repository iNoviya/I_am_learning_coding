let number = [0,1,2,3,4,5,6,7,8,9]

let even = number.filter((item => item%2 ==0))
console.log(even)

let fruit = ["apple","banana","tomato","orrange","stawberry","watermelon"]

let longFruit = fruit.filter(index => index.length > 7)
console.log(longFruit)


let userInfo = [
   {fullName: "Selda ÖZER", ages: 22, nation: "american"},
   {fullName: "Arda ER", ages: 11, nation: "american"},
   {fullName: "Elif ÖREK", ages: 32, nation: "american"},
   {fullName: "Banu ORAN", ages: 15, nation: "italian"},
   {fullName: "Batu ZERA", ages: 5, nation: "turkish"},
   {fullName: "Berra ERAN", ages: 80, nation: "turkish"},
]

let parent = userInfo.filter((age => age.ages >= 18))
console.log(parent)

let turkish = userInfo.filter((turkish => turkish.nation == "turkish"))
console.log(turkish)

let parentTurkish = userInfo.filter((person => person.nation=="turkish"&&person.ages>18))
console.log(parentTurkish)