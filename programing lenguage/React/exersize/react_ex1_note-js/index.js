console.log("hello Node-js")

import slugify from "slugify"
import sub from "./module_sub.js"
import squ from "./module/module_squre.js"

const title = slugify (`string is like a squarence words`)
console.log(title)

const title2 = slugify( "loren impusr adasd asd as dasd  asdas?","*_*")
console.log(title2)

console.log("the result of the operetor sub is = ",sub(3,8))
console.log(squ(3))