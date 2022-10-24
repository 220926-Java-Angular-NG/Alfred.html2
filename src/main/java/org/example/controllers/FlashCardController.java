package org.example.controllers;

import io.javalin.http.Handler;
import org.example.models.FlashCard;
//import org.example.services.FlashCardService;

//public class FlashCardController {
//
//    FlashCardService service;
//
//    public FlashCardController() {
//        service = new FlashCardService();
//    }
//
//    public Handler updateFlashCard = context -> {
//
//        //Creating a model of our flashcard using json from the request body
//        FlashCard card = context.bodyAsClass(FlashCard.class);
//
//        //We are assigning the card we just created above to the update card
//        //WE get from the db when we run our update method
//        card = service.updateFlashCard(card);{
//        }
//    };
//    //Delete
//    public Handler deleteFlashCard = context -> {
//
//        FlashCard card = context.bodyAsClass(FlashCard.class);
//
//        if(card != null){
//
//            if(service.deleteFlashCard(card)){
//                context.result("Flashcard with id: " + card.getId() + " has been deleted");
//            } else {
//                context.result("Could not delete flashcard");
//            }
//
//        } else {
//            context.result("No flashcard was added for deletion");
//        }
//
//    };
//
