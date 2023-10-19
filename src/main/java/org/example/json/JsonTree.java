package org.example.json;

import java.util.ArrayList;

/**
 * Tree to represent a JSON Object.
 */
public class JsonTree {

    private Node root;
    private int size;
    private ArrayList<Node> jsonObjectNodes;
    private String stringRepresentation;

    //Band-aid solution for recursive search. TODO: Rework this method of searching
    private JsonDataType searchResult;

    /**
     * Constructs a JsonTree with an initial size of 0.
     */
    public JsonTree(){
        size = 0;
        jsonObjectNodes = new ArrayList<>();
    }

    /**
     * Adds a JSON data type to the tree. The jsonObjectPos variable is how you choose WHERE to add the Node. The
     * program keeps a list of Nodes that record JSON Object nodes, so you indicate which Object the data type will go
     * into by inputting its index. Ex, the initial object should have a jsonObjectPos should be 0.
     * @param data          The JsonDataType object that you wish to add to the tree
     * @param jsonObjectPos Which Node this newly created Node will be added to as a child Node
     */
    public void add(JsonDataType data, int jsonObjectPos){
        //The first element to be added will always be a JSON Object and the root
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
     * Returns the LAST data type with the inputted identifier.
     * @param identifier    The identifier of the wanted data type
     * @return  The first occurrence of a data type with the inputted identifier
     */
    private JsonDataType search(String identifier){
        DFS(root, identifier);
        return searchResult;
    }

    private void DFS(Node currentNode, String identifier){
        //If a Node has child nodes, need to parse through them first
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

    public String buildStringRepresentation(){
        stringRepresentation = "";
        DFSBuildString(root);
        return stringRepresentation;
    }

    private void DFSBuildString(Node currentNode){
        //Setting up the strings for the brackets
        String beg = "{";
        String end = "}";

        //If a Node has child nodes, need to parse through them first
        //It's either a JsonObject or a JsonArray, and we need to find out which since arrays require more
        if (currentNode.data instanceof JsonArray){
            beg = "[";
            end = "]";
        }
        if (currentNode.hasChildren()){
            stringRepresentation += currentNode.data.getIdentifier() + beg;
            for (Node child : currentNode.getChildrenArrayList()){
                DFSBuildString(child);
                stringRepresentation += ",";
            }
            //Remove the last comma of the string
            stringRepresentation = stringRepresentation.substring(0, stringRepresentation.length() - 1);
            stringRepresentation += end;
        }
        //Otherwise, add the data to the string
        else {
            stringRepresentation += currentNode.data.toJSONString();
        }
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
        private Node parent;
        private ArrayList<Node> children;
        private JsonDataType data;

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
