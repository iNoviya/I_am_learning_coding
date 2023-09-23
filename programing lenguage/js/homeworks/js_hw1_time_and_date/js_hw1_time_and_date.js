
function date (){
   let temp = document.getElementById(`time`)
   let date = new Date()
   const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

   const days = ["Sunday","Monday","Tuesday","Wednessday","Thursday","Friday","Saturday"]

   let mSecond = date.getMilliseconds()
   mSecond = mSecond.toString()
   mSecond.length < 2 ? mSecond = parseInt(mSecond,10) : mSecond = parseInt(mSecond.substring(0,2),10)

   let d = document.getElementById("day")
   d.innerHTML = days[date.getDay()]
   let m = document.getElementById("month")
   m.innerHTML = months[date.getMonth()]
   let y = document.getElementById("year")
   y.innerHTML = date.getFullYear()
   let h = document.getElementById("hour")
   h.innerHTML = date.getHours()
   let mn = document.getElementById("minute")
   mn.innerHTML = date.getMinutes()
   let s = document.getElementById("second")
   s.innerHTML = date.getSeconds()
   let ms = document.getElementById("ms")
   ms.innerHTML = mSecond

   
   // temp.innerHTML = day + " "+ month +" " + date.getFullYear() + " " +date.getHours() + " " + date.getMinutes() + " " +date.getSeconds() + " " + mSecond
}
date()
setInterval(date, 100);