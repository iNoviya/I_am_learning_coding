let person1 = {
   userName : "ahmet",
   userSurname : "KADAR",
   birthYear : 1968,
   userAge : function(){
      let date = new Date()
      return date.getFullYear() - this.birthYear 
   },
   hello : function(){
      return `Hi my name is ${this.userName}. i am ${this.userAge()} years old`
   }
   

}

console.log(person1.hello())
console.log(person1.userAge())

