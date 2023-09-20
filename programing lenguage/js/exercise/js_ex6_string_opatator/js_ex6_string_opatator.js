let email = "mskarats98@gmail.com"
let firstName = "mustafa"
let lastName = "KARATAS"

// String lenght
console.log(email.length)

// find first caracters
console.log(firstName[0])
console.log(firstName[1])
console.log(firstName.charAt(2))
console.log(firstName[3])
console.log(firstName.charAt(4))
console.log(firstName[5])
console.log(firstName.charAt(6))

// upper case //lower case
lastName = lastName.toLowerCase()
console.log(lastName)
console.log(firstName.toUpperCase())

// find a caracter

findCaracter = email.search(`@`)
console.log(findCaracter)
console.log(email.charAt(10))
console.log(email[findCaracter])

let ornot = email.search(`gmail.com`)

// slice

let DOMAIN = email.slice(findCaracter+1)
console.log(DOMAIN)

DOMAIN = DOMAIN.slice(0,DOMAIN.indexOf(".")) 
console.log(DOMAIN)


// chamge veriable
email = email.replace(`gmail`,`karatas`)
console.log(email)
console.log(`there are this ${email.includes(`karatas`)}`)
console.log(DOMAIN)

// end widh
console.log(
   email.endsWith(`karatas.com`)
   )
   

// do big first caractem in words
let fullName = `${firstName[0].toUpperCase()}${firstName.slice(1).toLowerCase()} ${lastName[0].toUpperCase()}${lastName.slice(1).toLowerCase()}`
console.log(fullName)
