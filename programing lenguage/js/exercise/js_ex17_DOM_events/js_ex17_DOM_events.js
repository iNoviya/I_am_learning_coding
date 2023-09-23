// click DOM event
function tik() {
   console.log("you clicked here")
   this.style.color =="red" ? this.style.color ="black" : this.style.color ="red"
}

info = document.querySelector(`#click`)
click.addEventListener(`click`, tik)

function mOver (obj){
   obj.innerHTML = `No i dont want raise `
   obj.style.backgroundColor="white"
   obj.style.color="black"
}
function mOut (obj) {
   obj.innerHTML = `I want a raise in my salary.`
   obj.style.backgroundColor="black"
   obj.style.color="white"
}
function mUp (obj){
   obj.innerHTML = "ofcourse, You are my best employer"
   obj.style.backgroundColor="red"
}