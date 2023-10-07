for (let i =0; i<10; i++){
   console.log(i)
}

for (let i =1; i<10;i++){
   for(let j =1;j<=i;j++){
      console.log(j)
   }
}

let names = ["arda","selin","nuri"]

for (let i = 0;names.length > i;i++ ){
   console.log(names[i])
}

let formula= [] // (n^2 + n)/2
// 0 <= n <= 10 

for (let n=0; n<10;n++) {
   formula[n] = (n*n+n)/2
}
console.log(formula)

let ulList = document.querySelector(`#list`)
ulList.classList.add("list-group","text-center")
for (let i = 0;i<=10;i++){
   const LIDOM = document.createElement(`li`) 
   for (let j = 0; j<=i;j++){

      LIDOM.innerHTML = LIDOM.innerHTML + " " + j 
      LIDOM.classList.add("list-group-item")
   }
   ulList.append(LIDOM)
}