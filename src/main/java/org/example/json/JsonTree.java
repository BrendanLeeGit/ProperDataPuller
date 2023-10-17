package org.example.json;

import java.util.ArrayList;

/**
 * Tree to represent a JSON Object :D. Only need to be able to add to it.
 */
public class JsonTree {

    private Node root;
    private int size;
    private ArrayList<Node> jsonObjectNodes;

    //Okay I know this is super ugly but I don't know how to do recursion properly. I'll push that back for later :D
    private JsonDataType searchResult;

    public JsonTree(){
        size = 0;
        jsonObjectNodes = new ArrayList<>();
    }

    /*
    TODO: Need to figure out how to add to the proper place all the time
    Maybe keep track of the different Nodes that contain objects
    and go from each to each depending on the brackets and parenthesis

    like keep all the nodes with several children in an arraylist and jump between them
    QUEUE, since it's first in last out ya know??? with brackets and shit

    Actually we'll rework this idea a bit, this will keep track of the JSON Objects while tree builder
    will send integers to see which JSON object to add to :) This is scuffed, sorry if anyone's reading this

     */

    public void add(JsonDataType data, int jsonObjectPos){
        //The first element to be added will always be a JSON Object and the root
        //It also should NOT contain any data ofc, since it's an object
        if (size == 0){
            root = new Node(null, new JsonObject());
            jsonObjectNodes.add(root);
            size++;
        }
        else{
            //If the data is a JsonObject, we need to add it to the ArrayList
            if (data instanceof JsonObject){
                jsonObjectNodes.add(jsonObjectNodes.get(jsonObjectPos).addChild(data));
            }
            //Else, we just add the child to the appropriate node and move on
            else{
                jsonObjectNodes.get(jsonObjectPos).addChild(data);
            }
        }
    }

    /**
     * Returns the LAST data type with the inputted identifier. Only one! The LAST one! Okay? Good. ONLY THE LAST!
     * Recall that JsonObjects don't seem to have identifiers so... yeah.
     * @param identifier    The identifier of the wanted data type
     * @return  The first occurrence of a data type with the inputted identifier
     */
    private JsonDataType search(String identifier){
        /*
        Need to implement a depth first search of this stuff. Oh my god not paying attention to Cicirello's class is
        coming back to bite me in the butt
         */

        DFS(root, identifier);
        return searchResult;
    }

    private void DFS(Node currentNode, String identifier){
        //If there's children we gotta dig deeper into them. That was a poorly worded statement
        if (currentNode.hasChildren()){
            for (Node child : currentNode.getChildrenArrayList()){
                DFS(child, identifier);
            }
        }
        //Otherwise, return the current data type if it matches the current node
        else {
            if (currentNode.data.getIdentifier().equals(identifier)){
                searchResult = currentNode.data;
            }
        }
        System.out.println(currentNode.data.toJSONString());
    }

    /**
     * Primitive version of the search that will return the found data as a string.
     * @return  The found data as a string
     */
    public String searchForData(String identifier){
        return (search(identifier).getDataAsString());
    }


    /**
     * Custom Node class specifically made to work with these data types and the tree.
     */
    public class Node {
        public Node parent;
        public ArrayList<Node> children;
        public JsonDataType data;

        public Node (Node previous, JsonDataType data){
            this.parent = previous;
            children = new ArrayList<>();
            this.data = data;
        }

        public Node addChild(JsonDataType data){
            //Passes itself as the parent and creates a new child node with the data
            Node newNode = new Node(this, data);
            children.add(newNode);

            //Return the created child node so that we can keep their references if needed
            return newNode;
        }

        public ArrayList<Node> getChildrenArrayList(){
            return children;
        }

        public Node getChild(int pos){
            return children.get(pos);
        }

        public boolean hasChildren(){
            return (!children.isEmpty());
        }
    }
}
