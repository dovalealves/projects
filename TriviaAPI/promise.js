function promiseHandler(resolve, reject) {

    setTimeout(function() {    // add a function later
        resolve("Great success!");
    }, 2000);   // 2 sec delay
}

//console.log("Testing, startin..");


const promise = new Promise(promiseHandler); // new instance of Promise class, passing handler - resolved == fullfiled 


/*//used when a promise is fulfilled
 promise.then(function(message) {
console.log("Promise has resolved with:", message);

 });

// catch used for after a promise has rejected
 promise.catch(function(error) {
    console.log("Fatality: ", err);
 });

// finally is used by the handler, after the promise is settle, either refuse or resolved!
 promise.finally(function() {
    console.log("Promise is done, either good or bad!");
 }); */

/*Promise Chaining
 new Promise(promiseHandler)
 .then(function(message) {

 })
 .catch(function(error) {
    console.log("Promise error:", error);
 })

 .finally(function(){
   console.log("Promise is done, either fulfilled or rejected"); 
 }) */



 function wait(ms) {
    return new Promise(function(resolve, reject) {
    if (ms < 0) {
        reject ('Invalid wait "${ms}".');
    } else {
        const startTime = performance.now();
        setTimeout(function() {
            const eplapsedTime = performance.now() - startTime;
            resolve(eplapsedTime);
        }, ms);
    }    
});
}



wait(1000)
.then((eplapsedTime) => console.log('Timer 1 is done! It took "${eplapsedTime}"ms.'))
.then(() => {
    return wait(-500);
})
.then((eplapsedTime) => console.log("Timer 2 is done! It took ${eplapsedTime}ms."))
.then(() => wait(1500))
.then((eplapsedTime) => console.log("Timer 3 is done. It took ${eplapsedTime}"))
.catch((error) => console.log('An error occured: ${error}.'))
.finally(() => console.log ("all done."));
