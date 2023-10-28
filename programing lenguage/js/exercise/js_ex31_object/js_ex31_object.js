let selin = {
   age : 25,
   nation : "turkish",
   id : 236,
   hairColor : "brown" 
}

console.log(selin)
console.log(selin.nation)

selin.heigh = 1.62
console.log(selin)

console.log(Object.keys(selin))
keys = Object.keys(selin)

keys.forEach(index => {
   console.log(index)
})

keys.forEach(item => {
   console.log(item,":",selin[item])
})

console.log(
   Object.values(selin)
)


let show = {
   showName:"How I Met Your Mother",
   characters:[
   {
    name:"Ted",
    age: 35,
    job: ["Architect"]
 },
 {
    name: "Robin",
    age: 32,
    job: ["News Anchor", "Pop-Star"]
 }
 ]
}

console.log(show.characters[1].age)
console.log(show.showName)