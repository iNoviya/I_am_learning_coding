fetch("https://jsonplaceholder.typicode.com/posts").then(
   response => response.json()
   ).then(responseJson => (console.log(responseJson[1])))



let SecDOM = document.getElementById("sec")

fetch("https://jsonplaceholder.typicode.com/todos").then(
   response2=> response2.json())
   .then(responseJson2 => {
   responseJson2.forEach(item => {
      let liDOM = document.createElement("li")
      liDOM.innerHTML = item.title
      SecDOM.appendChild(liDOM)
   });
})