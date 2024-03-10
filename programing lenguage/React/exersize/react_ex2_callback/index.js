// setTimeout(() => {
//    console.log("Takes action after the specified period of time")
// },1000 )

// setInterval(()=>{
//    console.log("It carries out that operation in the specified periods.")
// },1000)

// fetch(`https://jsonplaceholder.typicode.com/posts/3`)
//    .then(api1 =>api1.json())
//    .then(item => {
//       console.log("3.post\n",item)
//       fetch(`https://jsonplaceholder.typicode.com/todos/1`)
//       .then(api2 => api2.json())
//       .then(todos => {
//          console.log("1. todos \n",todos)
//          fetch(`https://jsonplaceholder.typicode.com/photos/2`)
//          .then(api3 => api3.json())
//          .then(photo => console.log("2. photo\n",photo))
//       })
//    })

// async function getData (){
//    const part1 = await ( 
//       await fetch(`https://jsonplaceholder.typicode.com/posts/3`)
//       ).json()
//    const part2 = await ( 
//       await fetch(`https://jsonplaceholder.typicode.com/todos/1`)
//       ).json()
//    const part3 = await ( 
//       await fetch(`https://jsonplaceholder.typicode.com/photos/2`)
//       ).json()

//    console.log("part 1\n",part1)
//    console.log("part 2\n",part2)
//    console.log("part 3\n",part3)
// }
// getData()

/* ghost function */ 
// (async =>{
//    console.log("this is a ghost function")
// })()
console.log("asdasdasd")


const sayhi = (cb )=> {
   cb()
}
sayhi (() => {
   console.log("hello world")
})

// const hi = (sayhi())
consolo.log(hi)