let mainTitle = document.querySelector(`#mainTitle`)
console.log(mainTitle.classList)

mainTitle.classList.add("bg-success","btn","text-white")
console.log(mainTitle.classList)
mainTitle.classList.remove("text-dark")
console.log(mainTitle.classList)

let subTitle = document.querySelector(`#subTitle`)
subTitle.classList.add("border","border-2","border-dark")