let info = document.querySelector("#temp")

let score = prompt("write your score")

if(score >=0 && score <=100){
   if(score >= 90){
      temp.classList.add("bi","bi-emoji-sunglasses-fill")
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent AA`
   }
   else if (score >= 85){
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent BA`
   }
   else if  (score >= 80){
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent BB`
   }
   else if (score >= 75){
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent BC`
   }
   else if (score >= 70){
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent CC`
   }
   else if (score >= 60){
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent DC`
   }
   else if (score >= 55){
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent DD`
   }
   else if (score >= 50){
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent FF`
   }
   else {
      temp.classList.add("bi","bi-emoji-frown-fill")
      temp.innerHTML = ` your exam score is ${score}. This is the letter grade equivalent ff`
   }
}
else{
   temp.innerHTML = "error parametry"
}

