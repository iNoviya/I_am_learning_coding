'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '0';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
  
    return inputString[currentLine++];
}



function main() {
    const n = parseInt(readLine());
    if(n%2==1 || (n>5 && n<21)){
    console.log("Weird")
    }
    else  
      {
    console.log("Not Weird")
    }
}
