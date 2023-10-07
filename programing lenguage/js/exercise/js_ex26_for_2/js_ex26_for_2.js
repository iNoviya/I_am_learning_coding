let vowels = ["a", "e", "i", "o", "u"]
const s = "javascriptloops"

function letters(word) {
  return word.split("")
}

let a = letters(s)
let p = []

for (let i = 0; i < a.length; i++) {
  let isVowel = false
  for (let j = 0; j < vowels.length; j++) {
    if (a[i] === vowels[j]) {
      console.log(a[i])
      isVowel = true
      break
    }
  }
  if (!isVowel) {
    p.push(a[i])
  }
}
for (let i = 0; i < p.length; i++) {
  console.log(p[i])
}