function factorial (n){
   let factor =1
   if(n>0 && n<=10){
     for(let i =1;i<=n;i++ ){
       factor = i*factor
     }
   }
   else(console.log("error"))
   return factor
 }
 