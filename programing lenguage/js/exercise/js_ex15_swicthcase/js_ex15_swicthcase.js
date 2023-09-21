let temp = document.querySelector("#temp")

let chosed = prompt("chose a number beetween 1-5")

switch(chosed){
   case `1`: 
      temp.innerHTML = `you are tired`;
      break;

   case `2`:
      temp.innerHTML = `you are upset`;
      break;

   case `3`:
      temp.innerHTML = `you are relaxed`;
      break;

   case `4`:
      temp.innerHTML = `you are unlucky`;
      break;

   case `5`:
      temp.innerHTML = `you are happy`;
      break;

   default: 
      temp.innerHTML = `error`;
}
