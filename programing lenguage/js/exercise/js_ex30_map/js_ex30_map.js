let user = ["lina", "HAZAL","emre","VoLKan","MUStaFA"]

console.log(user)
let names = user.map(person => person.toLocaleUpperCase())

console.log(names)

// let tamplateName = names.map( item => 
//    {
//       return{
//          userName: item, 
//          shortName: `${item[0]}${item[2]}`,
//          newName:`${item[0].toLocaleUpperCase()}${item.slice(1).toLocaleLowerCase()}`
//       }
//    }
// )

let tamplateName = names.map( item =>
   (
      {
         userName: item, 
         shortName: `${item[0]}${item[2]}`,
         newName:`${item[0].toLocaleUpperCase()}${item.slice(1).toLocaleLowerCase()}`   
      }
   )
)

console.log(tamplateName)

let employee = [
   {name:"arda", salary:"2120"},
   {name:"selin", salary:"1920"},
   {name:"salih", salary:"2300"},
   {name:"Özlem", salary:"1300"},
]

let newSalary = employee.map(person =>{
      // person.salary>2000 ? person.salary*1.25 : person.salary*1.35
      let newPerson = { ...person }
      if (person.salary > 2000 ) {
         newPerson.salary *= 1.25
      }
      else {
         newPerson.salary *= 1.35
      }
      newPerson.name = `${person.name[0].toLocaleUpperCase()}${person.name.slice(1).toLocaleLowerCase()}`
      return newPerson
   }
)
console.log(newSalary)