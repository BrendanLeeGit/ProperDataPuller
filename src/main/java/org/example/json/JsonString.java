package org.example.json;

/**
 * Used to represent a String from a JSON File.
 */
public class JsonString extends JsonDataType {
    private String identifier;
    private String data;

    /**
     * Constructs a JsonString with the inputted identifier and data.
     * @param identifier    The identifier for the JsonString
     * @param data          The String the JsonString will store
     */
    public JsonString(String identifier, String data){
        this.identifier = identifier;
        this.data = data;
    }

    /**
     * Returns the String data the JsonString contains.
     * @return  the String data the JsonString contains
     */
    public String getData(){
        return data;
    }

    /**
     * Returns the data type's String representation for a JSON file.
     * @return  The data type's String representation for a JSON file
     */
    @Override
    public String toJSONString() {
        //{"name":"John"}
        return "\"" + identifier + "\":\"" + data + "\"";
    }

    /**
     * Returns the data type's identifier as a String.
     * @return  The data type's identifier as a String
     */
    @Override
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Specifically returns the data of the object, not the identifier, as a normal, basic String.
     * @return  the data of the object as a String
     */
    @Override
    public String getDataAsString(){
        return data;
    }
}
