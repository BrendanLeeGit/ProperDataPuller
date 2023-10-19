package org.example.json;

/**
 * Represents a JSON Object.
 */
public class JsonObject extends JsonDataType {
    private String identifier;

    /**
     * Constructs a JsonObject with the inputted identifier.
     */
    public JsonObject(String identifier){
        this.identifier = identifier;
    }

    /**
     * Returns the data type's String representation for a JSON file.
     * @return  the data type's String representation for a JSON file
     */
    @Override
    public String toJSONString() {
        //TODO: Fnd proper way to print this object as text for a JSON file
        return "{}";
    }

    /**
     * Returns the data type's String representation for a JSON file when the string is a value of an array.
     * @return The data type's String representation for a JSON file
     */
    public String toJsonStringArrayValue(){
        return "{}";
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
        return "I haven't decided what this will return yet";
        //TODO: Figure out above lol
    }
}
