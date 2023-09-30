let score = localStorage.getItem("counter") !== null ? Number(localStorage.getItem("counter")) : 0

let counterDOM = document.querySelector('#score')
counterDOM.innerHTML = score 

function increase (){
   score += 1
   counterDOM.innerHTML = score 
   localStorage.setItem("counter", score )
}
function dicrease (){
   score -= 1
   counterDOM.innerHTML =score
   localStorage.setItem("counter",score)
}