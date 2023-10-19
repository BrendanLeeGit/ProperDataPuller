package org.example.json;

/**
 * Testing everything to make sure it'll work properly. Not actual unit tests.
 */
public class ProofOfConcept {

    public void run(){
        //Make a tree
        JsonTree jsonTree = new JsonTree();

        //Adds some values to the first
        jsonTree.add(new JsonObject(""), 2425); //TODO: Find a way less ugly way to add first node
        jsonTree.add(new JsonNumber("Age", 28), 0);
        jsonTree.add(new JsonString("Name", "Brendan"), 0);
        jsonTree.add(new JsonObject("\"Posessions\": "), 0);
        jsonTree.add(new JsonNumber("Money", -4), 0); //To represent my irl wallet

        //Add some values to the object within an object
        jsonTree.add(new JsonObject("\"Clothing\": "), 1);
        jsonTree.add(new JsonString("Car", "Honda"), 1);

        //Add some values to the object within an object within an object
        jsonTree.add(new JsonString("Shirt", "T-Shirt"), 2);
        jsonTree.add(new JsonString("Pants", "Jeans"), 2);

        //Array test
        jsonTree.add(new JsonArray("\"OtherStuff\": "), 2);
        jsonTree.add(new JsonString("Pocket", "Wallet"), 3);

        //Print the created JSON File
        System.out.println(jsonTree.buildStringRepresentation());

        //Search for pants
        System.out.println(jsonTree.searchForData("Pants"));

        //Testing reading a file
        System.out.println(FileReader.getStringOfFile("C:\\Users\\BLee\\Documents\\FilePullerDoc\\" +
                "test.json"));
    }

    public void creatFileTest(){
        //Make a tree
        JsonTree jsonTree = new JsonTree();

        //Make initial object
        jsonTree.add(new JsonObject(""), 0);
        jsonTree.add(new JsonString("OrderId", "01234"), 0);
        jsonTree.add(new JsonString("OrderDate", "January"), 0);
        jsonTree.add(new JsonString("Stuff", "Stuff2"), 0);
        jsonTree.add(new JsonArray("\"Information\": "), 0);
        jsonTree.add(new JsonObject(""), 1);
        jsonTree.add(new JsonString("Name", "Brendan"), 2);
        jsonTree.add(new JsonString("Social Security Number", "15"), 2);

        //Print the created JSON File
        System.out.println(jsonTree.buildStringRepresentation());
    }
}
