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

    public void add(JsonDataType data, int jsonObjectPos){
        //The first element to be added will always be a JSON Object and the root
        //It also should NOT contain any data ofc, since it's an object
        if (size == 0){
            root = new Node(null, data);
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
            System.out.println("{");
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
        //TODO: Remove test print lines here
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
