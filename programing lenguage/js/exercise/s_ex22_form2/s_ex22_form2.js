const LIST = document.querySelector('#list')


let userForm = document.querySelector('#userForm')
userForm.addEventListener('submit',function (event){
   event.preventDefault()
   
   const USER_NAME = document.querySelector('#userName')
   const SCORE = document.querySelector('#score')


   console.log("data received") 
   console.log(userName.value,score.value)
   localStorage.setItem("userName",USER_NAME)
   localStorage.setItem("socre",SCORE)
   
   if (USER_NAME.value && SCORE.value){
      addList(USER_NAME.value,SCORE.value)
      USER_NAME.value = ""
      SCORE.value = ""
   }
   else {
      alert("opppss, error!!! check your info")
   }
   
})

function addList (userName,score){
   let li = document.createElement('li')

   li.innerHTML = `${userName} ${score}`
   li.classList.add("list-group-item")
   LIST.append(li)
}

// function clearList() {
//    document.remove()
// }

function clearList() {
   while (LIST.firstChild) {
      LIST.removeChild(LIST.firstChild)
   }
}