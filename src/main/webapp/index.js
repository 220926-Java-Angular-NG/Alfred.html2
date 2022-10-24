// Access my sign up button
// Change the window to point at the register.html page for a user to sign up 
let signUpButton = document.getElementById("sign-up");

signUpButton.addEventListener('click', (event)=>{
    event.preventDefault();
    window.location.replace("register.html")
});




// We are taking in the username and password 
// Sending a request to our api (localhost)
// Then save our current current to our localStorage 
// Tell our webpage to point to our home.html page 

let loginButton = document.getElementById("login");

loginButton.addEventListener('click', async(event) =>{
    event.preventDefault();



    let username1 = document.getElementById("username-sign-in").value;
    let password1 = document.getElementById("password-sign-in").value;


    //Creating an JSON object using the input from the user
    //Note that the keys for our objects must match the 
    //fields in our Models in the backend

    let loginInfo = {
        username: username1,
        password: password1
    }

    //Turns our JSON object literal int JSON

    let json = JSON.stringify(loginInfo);

    try{

        const raw_response = await fetch (`http://localhost:8080/login`,{
            method:"POST", //We add the http to be executed
            body:json
    });
    
    if (!raw_response.ok){
        throw new Error(raw_response.status)

    }

    raw_response.json().then( (data) =>{
      //  console.log(data)
      let loggedInUser = JSON.stringify(data)

      localStorage.setItem("currentUser",loggedInUser)
      console.log(loggedInUser)
    })

    setTimeout( () =>{
        window.location.replace("home.html")
    }, 3000)
}catch(error){
    console.log(error)
}
})