let backButton = document.getElementById("back-button")

backButton.addEventListener('click', (event) => {
event.preventDefault();
window.location.replace("index.html")
})
// We are taking in the username and password 
// Sending a request to our api (localhost)
// Then save our current current to our localStorage 
// Tell our webpage to point to our home.html page 

let loginButton = document.getElementById("login");

loginButton.addEventListener('click', async(event) =>{
    event.preventDefault();

    let firstname1 = document.getElementById("firstname-sign-in").value;
    let lastname1 = document.getElementById("lastname-sign-in").value;
    let username1 = document.getElementById("username-sign-in").value;
    let password1 = document.getElementById("password-sign-in").value;
    let zodiac1 = document.getElementById("zodiac-sign-in").value;


    //Creating an JSON object using the input from the user
    //Note that the keys for our objects must match the 
    //fields in our Models in the backend

    let loginInfo = {
        firstname: firstname1,
        lastname: lastname1,
        username: username1,
        password: password1,
        zodiac: zodiac1
    }

    //Turns our JSON object literal int JSON

    let json = JSON.stringify(loginInfo);

    try{

        const raw_response = await fetch (`http://localhost:8080/user`,{
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