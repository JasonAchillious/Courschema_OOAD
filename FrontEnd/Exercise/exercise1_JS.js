
function calculate() {
    var num1 = document.getElementById('num1').value;
    var num2 = document.getElementById('num2').value;
    document.getElementById('result').value = parseFloat(num1)+parseFloat(num2);
}

function generate() {
    var text = document.getElementById('var1').value;
    document.getElementById("generate").innerText ='abcde:'+text;
}