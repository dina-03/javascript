/*console.log("Hello world")

function fi() {
    console.log("inside fi")
}

const a = 10;
const b = f2(a);
console.log('b equals to ${b}')

function f2(number) {
    return number * 2;
}

let numValue = Number(false)
let numValue2 = Number(true)

let value = 0 || '23'

//это комментарий для javascript
/!*alert(3 + 2 + 1);
alert("Hi, liebe Freunde");*!/
let message = 'Hello!';
alert(message);
let age=25;
let name='Johnson';
alert(name);
//alert(age);
age=30;
alert(age)
const COLOR_RED='#F00';
let color = COLOR_RED;
alert(color);*/

vasya = {
    name: "Vasya",
    "age": 23,
}

function passObject(obj) {
    for (let field in obj) {
        console.log(`${field}: ${obj[field]}`)
    }
}

passObject(vasya);
