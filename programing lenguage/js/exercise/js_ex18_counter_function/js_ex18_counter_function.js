function ingrease (add){
   add = document.querySelector(`#number`)
   let temp = Number(add.innerHTML) +1
   add.innerHTML = `${temp}` 
}

function digrease (sub){
   sub = document.querySelector(`#number`)
   let temp = Number(sub.innerHTML) - 1
   sub.innerHTML = `${temp}` 
}