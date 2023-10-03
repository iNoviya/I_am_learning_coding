let formDOM = document.querySelector('#userInfo');

formDOM.addEventListener("submit", function (event) {
   event.preventDefault() 
   console.log("Process complete")

   let lastNameDOM = document.querySelector('#lastName')
   console.log(lastNameDOM.value)
})
