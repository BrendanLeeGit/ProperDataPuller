package org.example.json;

/**
 * Testing everything to make sure it'll work properly. Not actual unit tests.
 */
public class ProofOfConcept {

    public void run(){
        //Make a tree
        JsonTree jsonTree = new JsonTree();

        //Adds some values to the first
        jsonTree.add(new JsonObject("FirstObject"), 2425); //TODO: Find a way less ugly way to add first node
        jsonTree.add(new JsonNumber("Age", 28), 0);
        jsonTree.add(new JsonString("Name", "Brendan"), 0);
        jsonTree.add(new JsonObject("SecondObject"), 0);
        jsonTree.add(new JsonNumber("Money", -4), 0); //To represent my irl wallet

        //Add some values to the object within an object
        jsonTree.add(new JsonObject("ThirdObject"), 1);
        jsonTree.add(new JsonString("Car", "Honda"), 1);

        //Add some values to the object within an object within an object
        jsonTree.add(new JsonString("Shirt", "T-Shirt"), 2);
        jsonTree.add(new JsonString("Pants", "Jeans"), 2);

        //Search for pants I suppose
        System.out.println(jsonTree.searchForData("Pants"));
    }
}
