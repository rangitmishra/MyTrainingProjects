Function.prototype.customBind = function () {
    var that = this;
    var oldArgs = Array.prototype.slice.call(arguments,1);
    var context = arguments.first;
    return function () {
        var newArgs = Array.prototype.slice.call(arguments,0);
      return that.apply(context, oldArgs.concat(newArgs));
    };
}
                               
function fun22(a,b,c) {
console.log(a+b+c);
}

var fun21 = fun22.customBind(null,5);
fun21(2,3,6,7);

var fun11 = fun22.customBind(null,6,64,3);
fun11(1,2,3,4);
