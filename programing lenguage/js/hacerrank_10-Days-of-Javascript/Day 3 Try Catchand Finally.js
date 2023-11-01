/* Complete the reverseString function
 * Use console.log() to print to stdout.
 */
function reverseString(s) {
    try{
      s.split()
      let s1 = []
      
      for(let i = 0;i<s.length;i++){
        s1.push(s[i])
      }
      s1.reverse()
      let s2 = s1.join("")
      
      console.log(s2)
    }
    catch(index){
      console.log("s.split is not a function")
      console.log(s)
    }
}