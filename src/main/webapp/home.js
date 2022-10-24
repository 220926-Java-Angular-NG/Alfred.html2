let currentUser = localStorage.getItem("currentUser");
currentUser = JSON.parse(currentUser);
console.log(currentUser);

let welcomeLabel = document.getElementById("welcome-label");
welcomeLabel.innerHTML = `Welcome ${currentUser.firstname}! `

if (currentUser.mood == null){
    currentUser.mood = "";
}
let userLabel = document.getElementById("users-label");
userLabel.innerHTML = ` Firstname : ${currentUser.firstname} <br> Lastname : ${currentUser.lastname}<br> Username : ${currentUser.username}<br> Password : ${currentUser.password}<br> Zodiac : ${currentUser.zodiac}<br> Mood : ${currentUser.mood}`


// let submitButton = document.getElementById("submit-button");

// submitButton.addEventListener('click', async(event) => {
//     event.preventDefault();

//     let questionText = document.getElementById("question").value;
//     let answerText = document.getElementById("answer").value;


//     // console.log(`Question: ${questionText} - Answer: ${answerText}`)

//     let cardObject = {
//         question:questionText,
//         answer:answerText,
//         creatorId:currentUser.id
//     }

//     let json = JSON.stringify(cardObject);


//     try {

//         let raw_response = await fetch(`http://localhost:8080/flashcard`,{
//             method:"POST",
//             body:json
//         })

//         if(!raw_response.ok){
//             throw new Error(raw_response.status)
//         }

//         alert("You're card was created!")
//         let questionBox = document.getElementById("question");
//         questionBox.value = "";
//         let answerBox = document.getElementById("answer");
//         answerBox.value = "";


//     } catch(error){
//        console.log(error)
//     }
// })

// let viewAllButton = document.getElementById("view-all");
// viewAllButton.addEventListener("click", async(event) => {
//     event.preventDefault();

//     try {
//         // fetch send a get request by default unless directed to do otherwise
//         let raw_response = await fetch(`http://localhost:8080/flashcards`)

//         if(!raw_response.ok){
//             throw new Error(raw_response.status)
//         }

//         raw_response.json().then( (data) => {

//             // create a helper function that will use the json data from the request to manipulate the dom
//             // console.log(data); print the array we get back from our http request

//             addFlashcardsToPage(data);

//         })

//     } catch(error){
//         console.log(error)
//     }
// })

// function addFlashcardsToPage(cardArray){

//     let cardButtonP = document.getElementById("card-button");

//     let br = document.createElement('br');

//     cardButtonP.append(br);
//     cardButtonP.append(br);


//     for(let card of cardArray){
//         let cardElement = document.createElement("h3");
//         cardElement.innerHTML = `Question: ${card.question} - Answer: ${card.answer}`
//         cardButtonP.appendChild(cardElement);
//     }



let horoscopeButton = document.getElementById("horoscope-label");

//add an event listener to our button

horoscopeButton.addEventListener('click', async()=>{

    //get the value from our user input field (ie the text box)
     let inputValue = currentUser.zodiac.toLowerCase();

    // send a request to the pokemon api
    // to do that we have to wrap our code in a try catch
    try{

        // this fetch method implicityly returns a Promise
        const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${inputValue}/today
        `);

        if(!raw_response.ok){
          //  throw new Error((raw_response).status)
          alert(`Error Status: ${raw_response.status}`);
        }

        const json_data = await raw_response.json();

        console.log(json_data);
            // here we are calling our 'addPokemonToPage' helper function
            // this helper function is specifically to manipulate our DOM
            // and passing in the 'json-data' we recieve from our api call
            addHoroscopeToPage(json_data);

    }catch(error){
        console.log(error);

    }
})

function addHoroscopeToPage(json_data){

    // this is where we will manipulate our DOM

    // var input = document.getElementById("input");
    var horoscope = document.createElement('h4');

    //note: append vs appendChild

    horoscope.innerHTML = `Today's Horoscope: ${json_data.horoscope}`
    input.append(horoscope);

    // var br = document.createElement('br');
    // input.append(br);

    // var pokeId = document.createElement('h3');
    // pokeId.innerHTML = `ID: ${json_data.id}`;
    // input.append(pokeId);
    // input.append(br);

    // var image = document.createElement('img');
    // image.setAttribute('src', json_data.sprites.front_default);
    // image.setAttribute('height', "300");
    // image.setAttribute('width', "300");

    // input.append(image);
    // input.append(br);

    // var int = document.createElement('hr');
    // input.append(line);


}
let moodButton = document.getElementById("button");

moodButton.addEventListener('click', async() =>{

    //get the value from our user input field (ie the text box)
     let inputValue = currentUser.zodiac.toLowerCase();

    // send a request to the pokemon api
    // to do that we have to wrap our code in a try catch
    try{

        // this fetch method implicityly returns a Promise
        const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${inputValue}/today
        `);

        if(!raw_response.ok){
          //  throw new Error((raw_response).status)
          alert(`Error Status: ${raw_response.status}`);
        }

        const json_data = await raw_response.json();

        console.log(json_data);
            // here we are calling our 'addPokemonToPage' helper function
            // this helper function is specifically to manipulate our DOM
            // and passing in the 'json-data' we recieve from our api call
            addMoodToDB(json_data);

    }catch(error){
        console.log(error);

    }
})

async function addMoodToDB (json_data){

    currentUser.mood = json_data.meta.mood

    // this is where we will manipulate our DOM

    // var input = document.getElementById("input");
    // var horoscope = document.createElement('h2');

    // //note: append vs appendChild

    // horoscope.innerHTML = `${json_data.horoscope}`
    // input.append(horoscope);
    let json = JSON.stringify(currentUser);

    try{

        const raw_response = await fetch (`http://localhost:8080/user`,{
            method:"PUT", //We add the http to be executed
            body:json
    });
    
    if (!raw_response.ok){
        throw new Error(raw_response.status)

    }
    
    userLabel.innerHTML = ` Firstname : ${currentUser.firstname} <br> Lastname : ${currentUser.lastname}<br> Username : ${currentUser.username}<br> Password : ${currentUser.password}<br> Zodiac : ${currentUser.zodiac}<br> Mood : ${currentUser.mood}`

    // raw_response.json().then( (data) =>{
    //   //  console.log(data)
    //   let loggedInUser = JSON.stringify(data)

    //   localStorage.setItem("currentUser",loggedInUser)
    //   console.log(loggedInUser)
    // })

    // setTimeout( () =>{
    //     window.location.replace("home.html")
    // }, 3000)
}catch(error){
    console.log(error)
}
}
